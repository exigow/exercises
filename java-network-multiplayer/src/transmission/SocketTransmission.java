package transmission;

import java.io.*;
import java.net.Socket;

public class SocketTransmission {

  private final Socket socket;

  public SocketTransmission(Socket socket) {
    this.socket = socket;
  }

  public void send(Object str) {
    System.out.println("SEND: " + str.toString());
    try {
      ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
      out.writeObject(str);
      out.flush();
      out.close();
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
