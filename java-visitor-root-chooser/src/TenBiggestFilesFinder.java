import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collection;

public class TenBiggestFilesFinder extends SimpleFileVisitor<Path> {

  private final static int MAX_ELEMENTS = 10;
  private final Collection<FileRecord> records = new ArrayList<FileRecord>();

  public Collection<FileRecord> find(Path root) {
    try {
      Files.walkFileTree(root, this);
    } catch (IOException e) {
      System.err.println("Can't walk");
      e.printStackTrace();
    }
    return records;
  }

  @Override
  public FileVisitResult visitFile(Path path, BasicFileAttributes attributes) {
    if (records.size() < MAX_ELEMENTS) {
      records.add(new FileRecord(path, attributes));
      return FileVisitResult.CONTINUE;
    }
    FileRecord candidate = findCandidateForReplace(attributes);
    if (candidate != null) {
      records.remove(candidate);
      records.add(new FileRecord(path, attributes));
    }
    return FileVisitResult.CONTINUE;
  }

  private FileRecord findCandidateForReplace(BasicFileAttributes checkedAttributes) {
    for (FileRecord record : records)
      if (checkedAttributes.size() > record.attributes.size())
        return record;
    return null;
  }



}
