import javax.swing.*;

public class Runner {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        try {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
          System.err.println("Can't set native look and feel");
          e.printStackTrace();
        }
        new Frame();
      }
    });
  }
}