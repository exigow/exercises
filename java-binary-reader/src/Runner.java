import java.io.IOException;

public class Runner {

  public static void main(String[] args) throws IOException {
    byte[] bytes = BinaryReader.read("java-binary-reader/test.bin");
    String dirty = new BytesToUtfProcessor().getString(bytes);
    System.out.println(clearString(dirty));
  }

  private static String clearString(String source) {
    return source.replaceAll("\\W*", "");
  }


}
