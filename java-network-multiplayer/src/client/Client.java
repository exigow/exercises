package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class Client extends JFrame {

  public Client() {
    setTitle("Simple example");
    setSize(300, 200);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    String nick = getNick();
    if (nick == null)
      close();
    System.out.println(nick);
  }

  private String getNick() {
    String nick = JOptionPane.showInputDialog(null,
      "What is your nick?",
      "Enter your nick",
      JOptionPane.QUESTION_MESSAGE);
    if (isBlank(nick))
      return null;
    return nick;
  }

  private boolean isBlank(String str) {
    return str == null || str.isEmpty();
  }

  private void close() {
    JOptionPane.showMessageDialog(this, "Nick is not specified. Closing client.");
    dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {

      @Override
      public void run() {
        new Client() {{
            setVisible(true);
        }};
      }

    });
  }

}
