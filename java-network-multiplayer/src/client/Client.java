package client;

import dialogs.IpAddressDialog;
import dialogs.NickDialog;
import dialogs.PortDialog;

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
    String port = new PortDialog(this).execute();
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
