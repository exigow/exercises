package testing.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class TestFinder {

  public Set<String> collect(Path root) {
    final Finder finder = new Finder();
    try {
      Files.walkFileTree(root, finder);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new TreeSet<String>() {{
      for (File file : finder.files)
        add(extractName(file.getName()));
    }};
  }

  private static class Finder extends SimpleFileVisitor<Path> {

    final Collection<File>
      files = new ArrayList<File>();

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attributes) {
      File visited = path.toFile();
      String extension = extractExtension(visited.getName());
      if (isTest(extension))
        files.add(visited);
      return FileVisitResult.CONTINUE;
    }

  }

  private static boolean isTest(String extension) {
    return (extension.equals("in") || extension.equals("out"));
  }

  private static String extractExtension(String filename) {
    String[] split = filename.split("\\.");
    return split[split.length - 1];
  }

  private static String extractName(String filename) {
    return filename.split("\\.")[0];
  }

}
