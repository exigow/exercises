package table.model;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class PersonRecord {

  private final static String DATE_FORMAT = "yyyy-MM-dd";

  public final String name;
  public final String lastName;
  public final Date date;
  public final Color color;
  public final Integer height;
  public final Integer mass;
  public final Integer bmi;

  public PersonRecord(String[] words) {
    name = words[0];
    lastName = words[1];
    date = parseDate(words[2]);
    color = parseColor(words[3]);
    height = new Integer(words[4]);
    mass = new Integer(words[5]);
    bmi = calculateBmi(height, mass);
  }

  private Color parseColor(String color) {
    String[] values = color.split(",");
    return new Color(
      new Integer(values[0]),
      new Integer(values[1]),
      new Integer(values[2])
    );
  }

  private Date parseDate(String date) {
    try {
      return new SimpleDateFormat(DATE_FORMAT).parse(date);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return null;
  }

  private Integer calculateBmi(Integer height, Integer mass) {
    double heightInMeters = (float)height / 100f;
    return (int)(mass / (heightInMeters * heightInMeters));
  }

}
