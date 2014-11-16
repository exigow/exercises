package server;

import javax.swing.*;
import java.awt.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends JFrame {

  private final JTextArea logger = new JTextArea(20, 40) {{
    setMargin(new Insets(5, 5, 5, 5));
    setEditable(false);
  }};

  private final int port;

  public Server(int port) {
    this.port = port;
    setTitle("server");
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    add(new JScrollPane(logger), BorderLayout.CENTER);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
    logLine("creating window");
  }

  private void logLine(String text) {
    logger.append("# " + text + "\n");
    logger.setCaretPosition(logger.getDocument().getLength());
  }

  public void execute() throws Exception {
    logLine("listening on port " + port);
    ServerSocket listener = new ServerSocket(port);
    try {
      while (true) {
        Socket socket = listener.accept();
        new Service(socket).start();
      }
    } finally {
      listener.close();
    }
  }

}
