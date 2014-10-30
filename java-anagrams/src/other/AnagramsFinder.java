package other;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class AnagramsFinder {

  private final static String ANAGRAM_TO_FIND = "cheater";

  public static void main(String[] args) throws IOException {
    Path path = Paths.get("java-anagrams/english_words_LIN.txt");
    List<String> lines = Files.readAllLines(path, Charset.defaultCharset());
    for (String line : AnagramsFinder.search(ANAGRAM_TO_FIND, lines))
      System.out.println(line);
  }

  private static Collection<String> search(final String source, final Collection<String> data) {
    return new ArrayList<String>() {{
      for (String line : data)
        if (isAnagram(line, source))
          add(line);
    }};
  }

  private static boolean isAnagram(String s1, String s2){
    return s1.length() == s2.length() && disassemble(s1).equals(disassemble(s2));
  }

  private static String disassemble(String source) {
    char[] chars = source.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }

}
