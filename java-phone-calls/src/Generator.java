import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Generator {

  public static void generateAndSaveRecords(String file) throws IOException {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
    for (int i = 0; i < 30000; i++)
      out.println(Record.generate().printRecord());
    out.close();
  }

  public static void main(String[] args) throws IOException {
    Generator.generateAndSaveRecords("java-phone-calls/calls.data");
  }

}
