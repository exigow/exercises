package server;

import transmission.SocketTransmission;

import java.net.Socket;

public class Connector extends Thread {

  private final Socket socket;
  private final Server server;
  private boolean connected = false;

  public Connector(Server server, Socket socket) {
    this.server = server;
    this.socket = socket;
    System.out.println("creating new listener: " + this);
  }

  @Override
  public void run() {
    SocketTransmission transmission = new SocketTransmission(socket);
    transmission.sendMsg("hello!");
  }

  @Override
  public String toString() {
    return "listener -> " + socket.toString();
  }

}
