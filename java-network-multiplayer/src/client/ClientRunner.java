package client;

import dialogs.IpAddressDialog;
import dialogs.NickDialog;
import dialogs.PortDialog;

public class ClientRunner {

  public static void main(String[] args) throws Exception {
    String nick = new NickDialog().execute();
    String ip = new IpAddressDialog().execute();
    String port = new PortDialog().execute();
    int portValue = Integer.parseInt(port);
    new Client(nick, ip, portValue).execute();
  }

}
