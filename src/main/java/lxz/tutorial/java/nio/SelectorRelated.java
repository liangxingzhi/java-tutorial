package lxz.tutorial.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectorRelated {

  private static final int BUF_SIZE = 1024;
  private static final int PORT = 8080;
  private static final int TIMEOUT = 3000;


  public static void main(String[] args) {
    try {
      openSelector();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void openSelector() throws IOException {
    ServerSocketChannel channel = ServerSocketChannel.open();
    channel.bind(new InetSocketAddress(PORT));

    Selector selector = Selector.open();
    channel.configureBlocking(false);

    channel.register(selector, SelectionKey.OP_ACCEPT);

    while (true) {
      int readyChannels = selector.select(TIMEOUT);
      if (readyChannels == 0) {
        continue;
      }
      Set<SelectionKey> selectedKeys = selector.selectedKeys();
      Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
      while (keyIterator.hasNext()) {
        SelectionKey key = keyIterator.next();
        if (key.isAcceptable()) {
          // a connection was accepted by a ServerSocketChannel.
          System.out.println("someone connected");
          handleAccept(key);
        } else if (key.isConnectable()) {
          System.out.println("a connection was established with a remote server");
          // a connection was established with a remote server.
        } else if (key.isReadable()) {
          System.out.println("a channel is ready for reading");
          handleRead(key);
          // a channel is ready for reading
        } else if (key.isWritable()) {
          System.out.println("a channel is ready for writing");
          handleWrite(key);
          // a channel is ready for writing
        }
        keyIterator.remove();
      }
    }
  }

  public static void handleAccept(SelectionKey key) throws IOException {
    ServerSocketChannel ssChannel = (ServerSocketChannel) key.channel();
    SocketChannel sc = ssChannel.accept();
    sc.configureBlocking(false);
    sc.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocateDirect(BUF_SIZE));
  }

  public static void handleRead(SelectionKey key) throws IOException {
    SocketChannel sc = (SocketChannel) key.channel();
    ByteBuffer buf = (ByteBuffer) key.attachment();
    long bytesRead = sc.read(buf);
    //将channel中的数据读取到buf中，如果返回值为0就是读取完成，如果大于0就循环继续读区，如果是-1说明客户端已经关闭
    while (bytesRead > 0) {
      buf.flip();
      while (buf.hasRemaining()) {
        System.out.print((char) buf.get());
      }
      System.out.println();
      buf.clear();
      bytesRead = sc.read(buf);
    }
    buf.put("haha".getBytes());
    buf.flip();
    sc.write(buf);
    buf.clear();

    //客户端断开连接，那么读到的字节数就是-1
    if (bytesRead == -1) {
      key.cancel();
      try {
        sc.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public static void handleWrite(SelectionKey key) throws IOException {
    ByteBuffer buf = (ByteBuffer) key.attachment();
    buf.flip();
    SocketChannel sc = (SocketChannel) key.channel();
    while (buf.hasRemaining()) {
      sc.write(buf);
    }
    buf.compact();
  }
}
