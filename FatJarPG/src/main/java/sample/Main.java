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
        final String connectionUrl = Optional.ofNullable(System.getenv("POSTGRESQL_CONNECTION_URL"))
          .orElse("jdbc:postgresql://centos/postgres?user=postgres&password=postgres&connections=100");
        final Optional<DB> optionalDB = DB.create(DB.Type.JDBC, connectionUrl);
        if (!optionalDB.isPresent()) {
            throw new NoDatabaseFound("could not connect to db.");
        }
        final DB db = optionalDB.get();
        final JSON json = JSON.create(JSON.Type.DslJsonPlatform);
        System.out.println(">>> json = " + json);
        Server.create()
                .listen(8091, "0.0.0.0")
                .get("/city", (req, res) -> {
                    List<City> allEntities = db.findAll(City.class);
                    json.toJson(allEntities).ifPresent(res::setContent);
                    res.write();
                })
                .start();
    }

    private static class NoDatabaseFound extends RuntimeException {
        public NoDatabaseFound(String message) {
            super(message);
        }
    }
}
