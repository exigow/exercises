package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    while (true) {
      String line = in.readLine();
      /*if (line.startsWith("SUBMITNAME")) {
        out.println(getName());
      } else if (line.startsWith("NAMEACCEPTED")) {
        textField.setEditable(true);
      } else if (line.startsWith("MESSAGE")) {
        messageArea.append(line.substring(8) + "\n");
      }*/
    }
  }

  /*private void run() throws IOException {
    String serverAddress = getServerAddress();
    Socket socket = new Socket(serverAddress, 9001);
    in = new BufferedReader(new InputStreamReader(
      socket.getInputStream()));
    out = new PrintWriter(socket.getOutputStream(), true);


    while (true) {
      String line = in.readLine();
      if (line.startsWith("SUBMITNAME")) {
        out.println(getName());
      } else if (line.startsWith("NAMEACCEPTED")) {
        textField.setEditable(true);
      } else if (line.startsWith("MESSAGE")) {
        messageArea.append(line.substring(8) + "\n");
      }
    }
  }*/

}
