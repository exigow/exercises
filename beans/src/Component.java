import javax.swing.*;
import java.awt.*;

public class Component extends JPanel {

  public Component(String label) {
    setLayout(new FlowLayout());
    add(new JLabel(label));
    add(new JSeparator());
    add(new JButton("asdasd"));
  }

}
