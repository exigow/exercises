import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class FileRecord {

  Path path;
  BasicFileAttributes attributes;

  public FileRecord(Path path, BasicFileAttributes attributes) {
    this.path = path;
    this.attributes = attributes;
  }

  @Override
  public String toString() {
    return "\"" + path.getFileName() + "\" [" + attributes.size() + "]";
  }

}