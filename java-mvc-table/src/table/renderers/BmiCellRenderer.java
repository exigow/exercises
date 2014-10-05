package table.renderers;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class BmiCellRenderer extends DefaultTableCellRenderer {

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
    JLabel label = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
    Integer bmi = (Integer)value;
    setLabelStyle(label, bmi);
    return label;
  }

  private void setLabelStyle(JLabel label, Integer bmi) {
    BmiType selectedType = getType(bmi);
    label.setBackground(selectedType.color);
    label.setFont(label.getFont().deriveFont(Font.BOLD));
    label.setHorizontalAlignment(SwingConstants.CENTER);
  }

  BmiType getType(Integer bmiValue) {
    for (BmiType type : BmiType.values())
      if (bmiValue > type.rangeFrom && bmiValue < type.rangeTo)
        return type;
    return BmiType.Normal;
  }

}
