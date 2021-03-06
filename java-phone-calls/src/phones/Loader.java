package phones;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Loader {

  public static List<int[]> loadRecordsFromFile(Path path) throws IOException {
    final List<String> lines = Files.readAllLines(path, Charset.defaultCharset());
    return new ArrayList<int[]>() {{
      for (String line : lines)
        add(Record.parseRecord(line));
    }};

  }

}
