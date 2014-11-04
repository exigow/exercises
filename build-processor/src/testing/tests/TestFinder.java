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

  public Collection<Test> collect(Path root) {
    final Finder finder = new Finder();
    try {
      Files.walkFileTree(root, finder);
    } catch (IOException e) {
      e.printStackTrace();
    }
    /*finder.sort();
    Collection<Test> tests = new ArrayList<Test>() {{
      for (final File file : finder.input)
        add(new Test() {{
          input = file;
        }});
    }};
    for (Test test : tests) {
      String name = extractName(test.input.getName());
      for ()
    }
    return tests;*/
    return null;



    // TODO  treeset? i wywalanie samuych nazw?
  }

  private static class Finder extends SimpleFileVisitor<Path> {

    final Collection<File>
      input = new ArrayList<File>(),
      output = new ArrayList<File>();

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attributes) {
      File visited = path.toFile();
      String extension = extractExtension(visited.getName());
      if (isTest(extension)) {
        if (extension.equals("in"))
          input.add(visited);
        if (extension.equals("out"))
          output.add(visited);
      }
      return FileVisitResult.CONTINUE;
    }

    public void sort() {
      Collections.sort((List<File>) input);
      Collections.sort((List<File>) output);
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
