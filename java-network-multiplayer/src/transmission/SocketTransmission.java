package transmission;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketTransmission {

  private BufferedReader in;
  public PrintWriter out;

  public SocketTransmission(Socket socket) {
    try {
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out = new PrintWriter(socket.getOutputStream(), true);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void sendMsg(String str) {
    System.out.println("SEND: " + str);
    out.println(str);
  }

  public String readMsg() {
    try {
      String read = in.readLine();
      System.out.println("READ: " + read);
      return read;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

}
