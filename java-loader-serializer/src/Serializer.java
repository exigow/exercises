import java.io.*;
import java.util.Collection;

public class Serializer {

  public static void serialize(Collection<Person> persons, String path) throws IOException {
    FileOutputStream fileOutputStream = new FileOutputStream(path);
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    objectOutputStream.writeObject(persons);
    objectOutputStream.close();
  }

  public static Object deserialize(String path) throws IOException, ClassNotFoundException {
    FileInputStream fileOutputStream = new FileInputStream(path);
    ObjectInputStream objectOutputStream = new ObjectInputStream(fileOutputStream);
    Object obj = objectOutputStream.readObject();
    objectOutputStream.close();
    return obj;
  }

}
