package client;

import transmission.SocketTransmission;

import java.io.IOException;
import java.net.Socket;

public class Client {

  private final String serverAddress;
  private final String name;
  private final int port;

  public Client(String serverAddress, String name, int port) {
    this.serverAddress = serverAddress;
    this.name = name;
    this.port = port;
  }

  public void run() throws IOException {
    Socket socket = new Socket(serverAddress, port);
    SocketTransmission transmission = new SocketTransmission(socket);
    System.out.println(transmission.read());
  }

}
