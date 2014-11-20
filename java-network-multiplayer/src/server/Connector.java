package server;

import transmission.SocketTransmission;

import java.net.Socket;

public class Connector extends Thread {

  private final Socket socket;
  private final Server server;
  private String name;

  public Connector(Server server, Socket socket) {
    this.server = server;
    this.socket = socket;
    System.out.println("creating new listener: " + this);
  }

  @Override
  public void run() {
    Object obj;
    do {
      SocketTransmission transmission = new SocketTransmission(socket);
      obj = transmission.read();
    } while (obj.equals("exit"));
  }

  @Override
  public String toString() {
    return "listener for \"" + name + "\", socket:" + socket.toString();
  }

}
