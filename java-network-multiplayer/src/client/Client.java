package client;

import transmission.SocketTransmission;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

public class Client extends JFrame {

  SocketTransmission transmission;
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
    getContentPane().add(textField, "North");
    getContentPane().add(new JScrollPane(messageArea), "Center");
    pack();
    textField.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        transmission.sendMsg(textField.getText());
        textField.setText("");
      }

    });
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
  }

  public void run() throws IOException {
    Socket socket = new Socket(serverAddress, port);
    transmission = new SocketTransmission(socket);
    while (true) {
      String line = transmission.readMsg();
      if (line.startsWith("SUBMITNAME")) {
        transmission.sendMsg(name);
      } else if (line.startsWith("NAMEACCEPTED")) {
        textField.setEditable(true);
      } else if (line.startsWith("MESSAGE")) {
        messageArea.append(line.substring(8) + "\n");
      }
    }
  }

}
