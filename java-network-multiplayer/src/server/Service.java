package server;

import transmission.SocketTransmissionIO;

import java.net.Socket;

public class Service extends Thread {

  private final Socket socket;

  public Service(Socket socket) {
    this.socket = socket;
  }

  public void run() {
    SocketTransmissionIO transmission = new SocketTransmissionIO(socket);
    transmission.send("hi! (from server)");
  }
}

