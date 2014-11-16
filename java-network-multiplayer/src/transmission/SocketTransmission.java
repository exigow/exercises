package transmission;

import java.io.*;
import java.net.Socket;

public class SocketTransmission {

  private DataInputStream in;
  private DataOutputStream out;

  public SocketTransmission(Socket socket) {
    try {
      in = new DataInputStream(socket.getInputStream());
      out = new DataOutputStream(socket.getOutputStream());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void sendMsg(String str) {
    System.out.println("SEND: " + str);
    try {
      out.writeUTF(str);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String readMsg() {
    try {
      String read = in.readUTF();
      System.out.println("READ: " + read);
      return read;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

}
