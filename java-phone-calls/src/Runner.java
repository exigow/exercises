import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Runner {

  public static void main(String[] args) throws IOException, NoSuchFieldException {
    Path path = Paths.get("java-phone-calls/calls.data");
    List<Record> records = Loader.loadRecordsFromFile(path);
    //FieldComparator<Record> comparator = new FieldComparator<Record>("call", Record.class);
    //Collections.sort(records, comparator);
    for (Record record : records)
      System.out.println(record);
  }

}
