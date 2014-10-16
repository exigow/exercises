import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;

public class Runner {

  public static void main(String[] args) throws IOException {
    Collection<Person> persons = Loader.load(Paths.get("java-loader-serializer/persons.dat"));
    for (Person person : persons)
      System.out.println(person);
  }

}
