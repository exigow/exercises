package transmission;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketTransmissionIO {

  public BufferedReader in;
  public PrintWriter out;

  public SocketTransmissionIO(Socket socket) {
    try {
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out = new PrintWriter(socket.getOutputStream(), true);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      in = null;
      out = null;
    }
  }

  public void send(String str) {
    out.print(str);
  }

  public String read() {
    try {
      return in.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

}
