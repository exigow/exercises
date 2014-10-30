package regex;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSearch {

  private final static String REGEX = "..un..r.";

  public static void main(String[] args) throws IOException {
    Path path = Paths.get("java-anagrams/english_words_LIN.txt");
    List<String> lines = Files.readAllLines(path, Charset.defaultCharset());
    Collection<String> matched = search(REGEX, lines);
    for (String line : matched)
      System.out.println(line);
  }

  private static Collection<String> search(String regex, final Collection<String> data) {
    final Pattern pattern = Pattern.compile(regex);
    return new ArrayList<String>() {{
      for (String line : data) {
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {
          add(line);
          System.out.println(line);
        }
      }
    }};
  }

}
