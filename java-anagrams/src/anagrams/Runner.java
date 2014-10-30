package anagrams;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Runner {

  public static void main(String[] args) throws IOException {
    Path path = Paths.get("java-anagrams/english_words_LIN.txt");
    List<String> lines = Files.readAllLines(path, Charset.defaultCharset());
    List<String[]> anagrams = AnagramCollector.build(lines);
    Collections.sort(anagrams, new ArraysLengthComparator<String>());
    prettyPrint(anagrams);
  }

  private static void prettyPrint(Collection<? extends Object[]> anagrams) {
    for (Object[] str : anagrams) {
      if (str.length > 1)
        System.out.println(Arrays.toString(str));
    }
  }

}
