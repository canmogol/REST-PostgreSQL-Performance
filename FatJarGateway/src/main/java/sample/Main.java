package sample;

import fatjar.Server;


public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.exampleServer();
    }

    private void exampleServer() {
        Server.create()
                .listen(8091, "0.0.0.0")
                .get("/endpoint", (req, res) -> {
                    res.setContent("{\"a\":1}");
                    res.write();
                })
                .start();
    }
}
