import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class Visitor extends SimpleFileVisitor<Path> {

  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) {
    System.out.println("Visiting file:" + file.getFileName());
    return FileVisitResult.CONTINUE;
  }

  @Override
  public FileVisitResult postVisitDirectory(Path directory, IOException e) throws IOException {
    System.out.println("Finished with the directory: "
      + directory.getFileName());
    return FileVisitResult.CONTINUE;
  }

  @Override
  public FileVisitResult preVisitDirectory(Path directory, BasicFileAttributes attributes) throws IOException {
    System.out.println("About to traverse the directory: "
      + directory.getFileName());
    return FileVisitResult.CONTINUE;
  }

  @Override
  public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
    System.out.println("A file traversal error occurred");
    return super.visitFileFailed(file, exc);
  }

}
