package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.*;

public class ChatClient {

  BufferedReader in;
  PrintWriter out;
  JFrame frame = new JFrame("Chatter");
  JTextField textField = new JTextField(40);
  JTextArea messageArea = new JTextArea(8, 40);

  private final String serverAddress;
  private final int port;

  public ChatClient(String serverAddress, int port) {
    this.serverAddress = serverAddress;
    this.port = port;
    textField.setEditable(false);
    messageArea.setEditable(false);
    frame.getContentPane().add(textField, "North");
    frame.getContentPane().add(new JScrollPane(messageArea), "Center");
    frame.pack();
    textField.addActionListener(new ActionListener() {
      /**
       * Responds to pressing the enter key in the textfield by sending
       * the contents of the text field to the server.    Then clear
       * the text area in preparation for the next message.
       */
      public void actionPerformed(ActionEvent e) {
        out.println(textField.getText());
        textField.setText("");
      }
    });
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  private String getName() {
    return JOptionPane.showInputDialog(
      frame,
      "Choose a screen name:",
      "Screen name selection",
      JOptionPane.PLAIN_MESSAGE);
  }

  public void run() throws IOException {
    Socket socket = new Socket(serverAddress, port);
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
  }

}
