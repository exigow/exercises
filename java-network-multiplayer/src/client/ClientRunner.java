package client;

import dialogs.IpAddressDialog;
import dialogs.PortDialog;

public class ClientRunner {

  public static void main(String[] args) throws Exception {
    String ip = new IpAddressDialog().execute();
    String port = new PortDialog().execute();
    int portValue = Integer.parseInt(port);
    new ChatClient(ip, portValue).run();
  }

}
