import java.io.IOException;

public class Runner {

  public static void main(String[] args) throws IOException {
    byte[] bytes = BinaryReader.read("java-binary-reader/test.bin");
    /*for (byte b : bytes)
      System.out.println(b);*/
    System.out.println(new String(bytes));
  }

}
