import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {

  public String name, lastName, phone;
  public Date date;

  // generated
  @Override
  public String toString() {
    return "Person{" +
      "name='" + name + '\'' +
      ", lastName='" + lastName + '\'' +
      ", phone='" + phone + '\'' +
      ", date=" + date +
      '}';
  }

}
