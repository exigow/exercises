import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BinaryReader {

  public static byte[] read(String file) throws IOException {
    Path path = Paths.get(file);
    return Files.readAllBytes(path);
  }

}
