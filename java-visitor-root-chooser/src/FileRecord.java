import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

class FileRecord {

  private final Path path;
  final BasicFileAttributes attributes;

  public FileRecord(Path path, BasicFileAttributes attributes) {
    this.path = path;
    this.attributes = attributes;
  }

  @Override
  public String toString() {
    return "\"" + path.getFileName() + "\" [" + attributes.size() + "]";
  }

}