package table;

import java.io.IOException;
import java.nio.file.Paths;

public class Runner {

    public static void main(String[] args) throws IOException {
      new PeopleTable(Paths.get("data.dat"));
    }

}
