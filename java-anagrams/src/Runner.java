import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Runner {

  public static void main(String[] args) throws IOException {

    List<String> lines = Files.readAllLines(Paths.get("java-anagrams/english_words_LIN.txt"), Charset.defaultCharset());
    //for (String line : lines) System.out.println(line);

    /*for (String line : regex.RegexSearch.search(".d.", lines))
      System.out.println(line);*/

    /*for (String line : Anagramer.search("enoz", lines))
      System.out.println(line);*/

    new AnagramCollector().build(lines);
  }

}
