package lxz.tutorial.java.exercises;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileWordCounting {

  private FileWordCounting() {
  }

  public static void main(String[] args) throws IOException {
    int result = count("/Users/admin/bash_profile.bak", "Java");
    System.out.println(result);
  }

  public static int count(String filePath, String word) throws IOException {
    int count = 0;
    try (
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(new FileInputStream(filePath)))) {
      String line;
      while ((line = reader.readLine()) != null) {
        int index;
        while ((index = line.indexOf(word)) != -1) {
          line = line.substring(index + word.length());
          count++;
        }
      }
    }
    return count;
  }
}
