package lxz.tutorial.java.fundamental;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileRelated {

  public static void main(String[] args) throws IOException {
    copy1("/Users/admin/heapDump-Idea-1507549580407.hprof.zip",
        "/Users/admin/heapDump-Idea-1507549580407.hprof.zip1");
  }

  public static void copy1(String src, String dest) throws IOException {
    long start = System.currentTimeMillis();
    try (InputStream inputStream = new FileInputStream(src)) {
      try (OutputStream outputStream = new FileOutputStream(dest)) {
        byte[] bytes = new byte[10240];
        int length;
        while ((length = inputStream.read(bytes)) != -1) {
          outputStream.write(bytes, 0, length);

        }
      }
    }
    System.out.println(System.currentTimeMillis() - start);
  }

  public static void copy2(String src, String dest) throws IOException {
    long start = System.currentTimeMillis();
    try (FileInputStream fis = new FileInputStream(src); FileChannel in = fis.getChannel()) {
      try (FileOutputStream fos = new FileOutputStream(dest); FileChannel out = fos.getChannel()) {
        ByteBuffer buffer = ByteBuffer.allocate(10240);
        while (in.read(buffer) != -1) {
          buffer.flip();
          out.write(buffer);
          buffer.clear();
        }
      }
    }
    System.out.println(System.currentTimeMillis() - start);
  }
}

