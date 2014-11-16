package client;

import transmission.SocketTransmissionIO;

import java.io.IOException;
import java.net.Socket;

public class Client {

  private final String serverIpAddress;
  private final int port;

  public Client(String nick, String serverIpAddress, int port) {
    this.serverIpAddress = serverIpAddress;
    this.port = port;
  }

  public void execute() throws IOException {
    Socket socket = new Socket(serverIpAddress, port);
    SocketTransmissionIO transmission = new SocketTransmissionIO(socket);
    transmission.send("hi! (from client)");
  }

}
