import javax.swing.*;

public class Frame extends JFrame {

  public Frame() {
    setTitle("Chooser");
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    add(new Panel());
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

}
