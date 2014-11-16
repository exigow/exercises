package server;

import dialogs.PortDialog;

public class ServerRunner {

  public static void main(String[] args) throws Exception {
    String port = new PortDialog().execute();
    int portValue = Integer.parseInt(port);
    new Server(portValue).execute();
  }

}
