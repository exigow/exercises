package phones;

import phones.comparator.ArrayComparator;
import phones.comparator.RecordComparator;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Runner {

  public static void main(String[] args) throws IOException, NoSuchFieldException {
    Path path = Paths.get("java-phone-calls/calls.data");
    List<int[]> records = Loader.loadRecordsFromFile(path);

    Collections.sort(records, ArrayComparator.ascending(ArrayComparator.getComparator(new ArrayComparator(0))));
    for (int[] record : records)
      System.out.println(Arrays.toString(record));
  }

}
