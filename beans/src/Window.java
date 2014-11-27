import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {

  public Window(String name) {
    super(name);
    setResizable(false);
  }

  private static JPanel createPanel() {
    return new JPanel() {{
      setLayout(new GridLayout(0, 2));
      add(new Component("Button"));
      add(new Component("Button"));
      add(new Component("Button"));
      add(new Component("Button"));
      add(new Component("Button"));
    }};
  }

  public static JPanel createControls() {
    JPanel controls = new JPanel();
    JButton applyButton = new JButton("Apply color");
    controls.add(applyButton);
    applyButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e){
        /*Color backgroundColor = JColorChooser.showDialog(getParent(),
          "Choose background color", Color.white);*/
      }

    });
    return controls;
  }

  public static void createAndShow() {
    new Window("Beans") {{
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      getContentPane().add(createPanel(), BorderLayout.NORTH);
      getContentPane().add(new JSeparator(), BorderLayout.CENTER);
      getContentPane().add(createControls(), BorderLayout.SOUTH);
      pack();
      setVisible(true);
    }};
  }

}
