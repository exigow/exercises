package table;

import table.model.PeopleModel;
import table.renderers.BmiCellRenderer;
import table.renderers.ColorCellRenderer;

import javax.swing.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class PeopleTable extends JFrame {

  public PeopleTable(Path path) throws IOException {
    List<String> loadedLines = Files.readAllLines(path, Charset.defaultCharset());
    PeopleModel model = new PeopleModel(loadedLines);
    JTable table = new JTable(model);
    table.getColumnModel().getColumn(3).setCellRenderer(new ColorCellRenderer());
    table.getColumnModel().getColumn(6).setCellRenderer(new BmiCellRenderer());
    add(new JScrollPane(table));
    setTitle("Table");
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    pack();
    setVisible(true);
  }

}
