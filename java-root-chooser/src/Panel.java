import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;

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

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == button) {
      int val = fc.showDialog(this, "Pick root");
      switch (val) {
        case JFileChooser.APPROVE_OPTION: {
          String root = fc.getCurrentDirectory().getAbsolutePath();
          logLine("selected root: \"" + root + "\"");
          Files.walkFileTree(f);
          break;
        }        case JFileChooser.CANCEL_OPTION: {
          logLine("cancelled");
          break;
        }
      }
    }
  }

  private void logLine(String text) {
    logger.append(text + "\n");
    logger.setCaretPosition(logger.getDocument().getLength());
  }

}