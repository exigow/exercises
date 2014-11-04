package testing;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collection;

public class TestFinder {

  public Collection<File> find(Path root) {
    Finder finder = new Finder();
    try {
      Files.walkFileTree(root, finder);
    } catch (IOException e) {
      e.printStackTrace();
    }
    for (File file : finder.files)
      System.out.println(file.toString());
    return finder.files;
  }

  private static class Finder extends SimpleFileVisitor<Path> {

    final Collection<File> files = new ArrayList<File>();

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attributes) {
      File visited = path.toFile();
      if (isTest(visited.getName()))
        files.add(visited);
      return FileVisitResult.CONTINUE;
    }

  }

  private static boolean isTest(String filename) {
    String extension = extractExtension(filename);
    return (extension.equals("in") || extension.equals("out"));
  }

  private static String extractExtension(String filename) {
    String[] split = filename.split("\\.");
    return split[split.length - 1];
  }

}
