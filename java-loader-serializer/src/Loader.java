import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Loader {

  public static Collection<Person> load(Path file) throws IOException {
    final List<String> loadedLines = Files.readAllLines(file, Charset.defaultCharset());
    return new ArrayList<Person>() {{
      for (final String line : loadedLines) {
        add(new Person() {{
          String[] words = getWords(line);
          name = words[0];
          lastName = words[1];
          try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(words[2]);
          } catch (ParseException e) {
            System.err.println("Can't parse date: " + words[2]);
            e.printStackTrace();
          }
          phone = words[3];
        }});
      }
    }};
  }

  public static void serializeTo(Collection<Person> persons, String path) throws IOException {
    FileOutputStream fileOutputStream = new FileOutputStream(path);
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    objectOutputStream.writeObject(persons);
    objectOutputStream.close();
  }

  private static String[] getWords(String line) {
    return line.split(":");
  }

}
