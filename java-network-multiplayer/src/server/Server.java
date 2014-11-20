package server;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Collection;

public class Server {

  public final Collection<Connector> connectors = new ArrayList<Connector>();
  private final int port;

  public Server(int port) {
    this.port = port;
  }

  public void execute() throws Exception {
    System.out.println("server start");
    ServerSocket serverSocket = new ServerSocket(port);
    while (connectors.size() < 2) {
      connectors.add(new Connector(this, serverSocket.accept()) {{
        start();
      }});
    }
    serverSocket.close();
  }

}
