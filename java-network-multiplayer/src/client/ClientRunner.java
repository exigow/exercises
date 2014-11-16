package client;

import dialogs.IpAddressDialog;
import dialogs.NickDialog;
import dialogs.PortDialog;

public class ClientRunner {

  public static void main(String[] args) throws Exception {
    String ip = new IpAddressDialog().execute();
    String port = new PortDialog().execute();
    String name = new NickDialog().execute();
    int portValue = Integer.parseInt(port);
    new Client(ip, name, portValue).run();
  }

}
