import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person implements Serializable {

  public final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

  public String name, lastName, phone;
  public Date date;

  // generated
  @Override
  public String toString() {
    return name + ":" + lastName + ":" + DATE_FORMAT.format(date) + ":" + phone;
  }

}
