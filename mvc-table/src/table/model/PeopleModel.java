package table.model;

import javafx.scene.paint.Color;

import javax.swing.table.AbstractTableModel;
import java.text.DateFormatSymbols;
import java.util.*;

public class PeopleModel extends AbstractTableModel {

  private final List<PersonRecord> records = new ArrayList<PersonRecord>();
  private final String[] names = new String[] {
    "Name", "Last name", "French", "Color", "Height", "Mass", "BMI"
  };
  private final Class[] classes = new Class[] {
    String.class, String.class, String.class, Color.class, Integer.class, Integer.class, Integer.class
  };

  public PeopleModel(List<String> lines) {
    for (String line : lines) {
      String[] words = getWords(line);
      PersonRecord record = new PersonRecord(words);
      records.add(record);
    }
  }

  private String[] getWords(String line) {
    return reduceMultipleSpaces(line).split(" ");
  }

  private String reduceMultipleSpaces(String before) {
    return before.trim().replaceAll(" +", " ");
  }

  @SuppressWarnings("deprecation")
  String getFrenchMonthName(Date date) {
    Locale frenchLocale = new Locale("FR");
    String[] months = DateFormatSymbols.getInstance(frenchLocale).getMonths();
    return months[date.getMonth()];
  }

  @Override
  public String getColumnName(int column) {
    return names[column];
  }

  @Override
  public Class<?> getColumnClass(int columnIndex) {
    return classes[columnIndex];
  }

  @Override
  public int getColumnCount() {
    return names.length;
  }

  @Override
  public int getRowCount() {
    return records.size();
  }

  @Override
  public Object getValueAt(int rowIndex, int index) {
    PersonRecord row = records.get(rowIndex);
    switch (index) {
      case 0: {
        return row.name;
      }
      case 1: {
        return row.lastName;
      }
      case 2: {
        return getFrenchMonthName(row.date);
      }
      case 3: {
        return row.color;
      }
      case 4: {
        return row.height;
      }
      case 5: {
        return row.mass;
      }
      case 6: {
        return row.bmi;
      }
    }
    return null;
  }
}
