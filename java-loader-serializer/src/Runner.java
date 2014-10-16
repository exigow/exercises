import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;

public class Runner {

  private final static String serializationFile = "java-loader-serializer/persons.jobj";

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    Collection<Person> persons = Loader.load(Paths.get("java-loader-serializer/persons.dat"));
    Serializer.serialize(persons, serializationFile);
    Collection<Person> personsDeserialized = (Collection<Person>)Serializer.deserialize(serializationFile);
    System.out.println(personsDeserialized);
  }

}
