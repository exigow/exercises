import java.io.IOException;
import java.util.*;

public class Runner {

  public static void main(String[] args) throws IOException {
    byte[] bytes = BinaryReader.read("java-binary-reader/test.bin");
    String dirty = new BytesToUtfProcessor().getString(bytes);
    String cleaned = clearString(dirty);
    Collection<String> strings = Arrays.asList(cleaned.split(" +"));
    Collections.sort((List)strings);
    TreeSet<String> treeSet = new TreeSet<String>(strings);
    for (String str : treeSet)
      System.out.println(str);
  }

  private static String clearString(String source) {
    return source.replaceAll("\\W", " ");
  }

}
