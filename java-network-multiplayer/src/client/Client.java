package client;

import client.dialogs.IpAddressDialog;
import client.dialogs.NickDialog;

import javax.swing.*;
import java.awt.*;

public class Client extends JFrame {

  public Client() {
    setTitle("Client");
    setSize(300, 200);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    String nick = new NickDialog(this).execute();
    String ip = new IpAddressDialog(this).execute();
    System.out.println(nick);
    System.out.println(ip);
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
