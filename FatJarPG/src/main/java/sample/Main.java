package sample;

import fatjar.DB;
import fatjar.JSON;
import fatjar.Log;
import fatjar.Server;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.exampleServer();
    }

    private void exampleServer() {
        final Optional<DB> optionalDB = DB.create(DB.Type.JDBC, "jdbc:postgresql://postgrest-db/postgres?user=postgres&password=postgres");
        if (!optionalDB.isPresent()) {
            throw new NoDatabaseFound("could not connect to db.");
        }
        List<List<Long>> metrics = new ArrayList<>();
        final DB db = optionalDB.get();
        final JSON json = JSON.create(JSON.Type.DslJsonPlatform);
        System.out.println(">>> json = " + json);
        Server.create()
                .listen(8091, "0.0.0.0")
                .get("/city", (req, res) -> {
                    List<Long> executions = new ArrayList<>();
                    final long methodStarted = System.currentTimeMillis();
                    List<City> allEntities = db.findAll(City.class);
                    final long dbQueried = System.currentTimeMillis();
                    executions.add(dbQueried - methodStarted);
                    json.toJson(allEntities).ifPresent(res::setContent);
                    final long jsonCreated = System.currentTimeMillis();
                    executions.add(jsonCreated - dbQueried);
                    res.write();
                    final long responseWritten = System.currentTimeMillis();
                    executions.add(responseWritten - jsonCreated);
                    executions.add(responseWritten - methodStarted);
                    metrics.add(executions);
                })
                .get("/metrics", (req, res) -> {
                    final String metricsCsv = metrics.stream()
                            .map(singleExecution ->
                                    singleExecution.stream().map(String::valueOf).collect(Collectors.joining(";"))
                            ).collect(Collectors.joining("\n"));
                    res.setContent(metricsCsv);
                    res.write();
                    metrics.clear();
                })
                .start();
    }

    private static class NoDatabaseFound extends RuntimeException {
        public NoDatabaseFound(String message) {
            super(message);
        }
    }
}
