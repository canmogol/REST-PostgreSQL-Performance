package sample;

import fatjar.DB;
import fatjar.JSON;
import fatjar.Server;

import java.util.List;
import java.util.Optional;


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
        DB db = optionalDB.get();
        JSON json = JSON.create();
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
