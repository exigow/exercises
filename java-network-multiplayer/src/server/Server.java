package server;

import transmission.SocketTransmission;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

public class Server extends JFrame {

  private static final HashSet<String> names = new HashSet<String>();
  private static final HashSet<PrintWriter> writers = new HashSet<PrintWriter>();

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
    System.out.println("The chat server is running.");
    ServerSocket listener = new ServerSocket(port);
    try {
      while (true)
        new Handler(listener.accept()).start();
    } finally {
      listener.close();
    }
  }

  private static class Handler extends Thread {

    private String name;
    private Socket socket;
    private SocketTransmission transmission;

    public Handler(Socket socket) {
      this.socket = socket;
    }

    public void run() {
      try {
        transmission = new SocketTransmission(socket);
        while (true) {
          transmission.out.println("SUBMITNAME");
          name = transmission.in.readLine();
          if (name == null)
            return;
          synchronized (names) {
            if (!names.contains(name)) {
              names.add(name);
              break;
            }
          }
        }
        transmission.out.println("NAMEACCEPTED");
        writers.add(transmission.out);
        while (true) {
          String input = transmission.in.readLine();
          if (input == null)
            return;
          for (PrintWriter writer : writers)
            writer.println("MESSAGE " + name + ": " + input);
        }
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        if (name != null)
          names.remove(name);
        if (transmission.out != null)
          writers.remove(transmission.out);
        try {
          socket.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

}
