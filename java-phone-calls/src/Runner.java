import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

public class Runner {

  public static void main(String[] args) throws IOException {
    Path path = Paths.get("java-phone-calls/calls.data");
    Collection<Record> records = Loader.loadRecordsFromFile(path);
    for (Record record : records)
      System.out.println(record);
  }

}
