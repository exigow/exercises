import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;

public class Runner {

  private final static String
    serializationFile = "java-loader-serializer/persons.jobj",
    datFile = "java-loader-serializer/persons.dat",
    datBackupFile = "java-loader-serializer/persons_bak.dat";

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    // load from dat
    Collection<Person> personsLoaded = Loader.load(Paths.get(datFile));
    System.out.println("loaded: " + personsLoaded);

    // serialize to jobj
    Serializer.serialize(personsLoaded, serializationFile);

    // deserialize from jobj
    Collection<Person> personsDeserialized = (Collection<Person>)Serializer.deserialize(serializationFile);
    System.out.println("deserialized: " + personsDeserialized);

    // write backup
    Loader.save(personsDeserialized, datBackupFile);
  }

}
