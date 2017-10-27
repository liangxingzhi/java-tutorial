package lxz.tutorial.java.exercises;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

public class ListFiles {

  private ListFiles() {

  }

  public static void main(String[] args) throws IOException {
    list("/Users/admin");
    System.out.println("-----------------");
    list2("/Users/admin");
  }

  public static void list(String path) {
    File f = new File(path);
    if (f.isDirectory()) {
      for (File fi : f.listFiles()) {
        if (fi.isFile()) {
          System.out.println(fi.getName());
        }
      }
    }
  }

  public static void list2(String path) throws IOException {
    Path initPath = Paths.get(path);
    Files.walkFileTree(initPath, new SimpleFileVisitor<Path>() {
      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
          throws IOException {

        System.out.println(file.getFileName().toString());
        return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
          throws IOException {
        if (dir.equals(initPath)) {
          return FileVisitResult.CONTINUE;
        }
        Objects.requireNonNull(dir);
        Objects.requireNonNull(attrs);
        return FileVisitResult.SKIP_SUBTREE;
      }

    });
  }
}
