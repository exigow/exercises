import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.util.Collection;

public class Panel extends JPanel implements ActionListener {

  private final JFileChooser fc = new JFileChooser() {{
    setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
  }};
  private final JButton button = new JButton("Open dialog") {{
    addActionListener(Panel.this);
  }};
  private final JTextArea logger = new JTextArea(20, 40) {{
    setMargin(new Insets(5, 5, 5, 5));
    setEditable(false);
  }};

  public Panel() {
    super(new BorderLayout());
    add(new JPanel() {{add(button);}}, BorderLayout.PAGE_END);
    add(new JScrollPane(logger), BorderLayout.CENTER);
  }

  public void actionPerformed(ActionEvent event) {
    if (event.getSource() == button) {
      logLine("opening dialog");
      int val = fc.showDialog(this, "PICK ROOT");
      switch (val) {
        case JFileChooser.APPROVE_OPTION: {
          Path root = fc.getCurrentDirectory().toPath();
          logLine("selected root path: \"" + root + "\"\n\tfounded:");
          logCollection(new TenBiggestFilesFinder().find(root));
          break;
        }
        case JFileChooser.CANCEL_OPTION: {
          logLine("dialog cancelled");
          break;
        }
      }
    }
  }

  private void logCollection(Collection collection) {
    for (Object object : collection)
      logLine(object.toString());
  }

  private void logLine(String text) {
    logger.append("# " + text + "\n");
    logger.setCaretPosition(logger.getDocument().getLength());
  }

}