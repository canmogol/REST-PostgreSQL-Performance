package fatjar.implementations.server;

import fatjar.Log;
import fatjar.Server;

import java.util.Map;

public class CurrentServer {

    private CurrentServer() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("never call constructor, use create method");
    }

    public static Server create(Server.Type type, Map<Server.ServerParams, String> params) {
        Server server = null;
        try {
            server = new UndertowServer(params);
        } catch (Exception e) {
            Log.error("could not create server of type: " + type + " error: " + e, e);
        }
        return server;
    }

}
