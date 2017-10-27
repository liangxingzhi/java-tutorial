package lxz.tutorial.java.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelRelated {

  public static void main(String[] args) throws Exception {
    RandomAccessFile aFile = new RandomAccessFile("/Users/admin/bash_profile.bak", "rw");
    FileChannel inChannel = aFile.getChannel();
    ByteBuffer buf = ByteBuffer.allocate(48);

    int bytesRead = inChannel.read(buf);
    while (bytesRead != -1) {

      System.out.println("Read " + bytesRead);
      buf.flip();

      while (buf.hasRemaining()) {
        System.out.print((char) buf.get());
      }

      buf.clear();
      bytesRead = inChannel.read(buf);
    }

    System.out.println(inChannel.position());
    ByteBuffer charBuffer = ByteBuffer.allocate(3);
    charBuffer.put((byte) '~');
    charBuffer.put((byte) '~');
    charBuffer.put((byte) '~');
    charBuffer.flip();
    inChannel.write(charBuffer);
    inChannel.close();
    aFile.close();

  }
}
