package table.renderers;

import java.awt.*;

public enum BmiType {

  Underweight(new Color(255, 255, 0), 0, 17),
  Obesity(new Color(255, 0, 0), 26, 100),
  Normal(new Color(255, 255, 255), -1, -1);

  BmiType(Color color, Integer rangeFrom, Integer rangeTo) {
    this.color = color;
    this.rangeFrom = rangeFrom;
    this.rangeTo = rangeTo;
  }

  public final Color color;
  public final Integer rangeFrom, rangeTo;

}