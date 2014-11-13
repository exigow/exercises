package phones;

import phones.comparator.RecordComparator;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Runner {

  public static void main(String[] args) throws IOException, NoSuchFieldException {
    Path path = Paths.get("java-phone-calls/calls.data");
    List<Record> records = Loader.loadRecordsFromFile(path);

    Collections.sort(records, RecordComparator.ascending(RecordComparator.getComparator(RecordComparator.CALLER_COMPARISON, RecordComparator.LENGTH_COMPARISON)));
    for (Record record : records)
      System.out.println(record);
  }

}
