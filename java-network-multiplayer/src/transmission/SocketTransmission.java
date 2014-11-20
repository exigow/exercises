package transmission;

import java.io.*;
import java.net.Socket;

public class SocketTransmission {

  private final Socket socket;

  public SocketTransmission(Socket socket) {
    this.socket = socket;
  }

  public void send(final Object str) {
    System.out.println("SEND: " + str.toString());
    try {
      new ObjectOutputStream(socket.getOutputStream()) {{
        writeObject(str);
        flush();
        close();
      }};
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Object read() {
    try {
      ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
      Object obj = in.readObject();
      System.out.println("READ: " + obj.toString());
      in.close();
      return obj;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

}
