package client;

import transmission.SocketTransmission;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.*;

public class Client {

  SocketTransmission transmission;
  JFrame frame = new JFrame("Chatter");
  JTextField textField = new JTextField(40);
  JTextArea messageArea = new JTextArea(8, 40);

  private final String serverAddress;
  private final String name;
  private final int port;

  public Client(String serverAddress, String name, int port) {
    this.serverAddress = serverAddress;
    this.name = name;
    this.port = port;
    textField.setEditable(false);
    messageArea.setEditable(false);
    frame.getContentPane().add(textField, "North");
    frame.getContentPane().add(new JScrollPane(messageArea), "Center");
    frame.pack();
    textField.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        transmission.out.println(textField.getText());
        textField.setText("");
      }

    });
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  /*private String getName() {
    return JOptionPane.showInputDialog(
      frame,
      "Choose a screen name:",
      "Screen name selection",
      JOptionPane.PLAIN_MESSAGE);
  }*/

  public void run() throws IOException {
    Socket socket = new Socket(serverAddress, port);
    transmission = new SocketTransmission(socket);
    while (true) {
      String line = transmission.in.readLine();
      if (line.startsWith("SUBMITNAME")) {
        transmission.out.println(name);
      } else if (line.startsWith("NAMEACCEPTED")) {
        textField.setEditable(true);
      } else if (line.startsWith("MESSAGE")) {
        messageArea.append(line.substring(8) + "\n");
      }
    }
  }

}
