import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
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
            date = DATE_FORMAT.parse(words[2]);
          } catch (ParseException e) {
            System.err.println("Can't parse date: " + words[2]);
            e.printStackTrace();
          }
          phone = words[3];
        }});
      }
    }};
  }

  public static void save(Collection<Person> persons, String file) throws IOException {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
    for (Person person : persons)
      out.print(person.toString() + "\n");
    out.close();
  }

  private static String[] getWords(String line) {
    return line.split(":");
  }

}

