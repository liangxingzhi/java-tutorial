package lxz.tutorial.java.exercises;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;

public class EchoServerNio {

  private static final int port = 8888;
  private static final String host = "127.0.0.1";
  private static final int timeout = 3000;
  private static final int buffersize = 256;


  static Selector selector;
  static CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
  static CharsetEncoder encoder = Charset.forName("UTF-8").newEncoder();

  public static void main(String[] args) throws IOException {
    accept();
  }

  public static void accept() throws IOException {
    ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
    serverSocketChannel.socket().bind(new InetSocketAddress(port));
    serverSocketChannel.configureBlocking(false);
    selector = Selector.open();
    serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    while (true) {
      if (selector.select() != 0) {
        Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
        while (iterator.hasNext()) {
          SelectionKey key = iterator.next();
          handleKey(key);
          iterator.remove();
        }
      }
    }
  }

  private static void handleKey(SelectionKey key) throws IOException {
    if (key.isAcceptable()) {
      ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
      SocketChannel socketChannel = serverSocketChannel.accept();
      socketChannel.configureBlocking(false);
      socketChannel.register(selector, SelectionKey.OP_READ);
      System.out.println("new client is connected : " + socketChannel.getRemoteAddress());
    } else if (key.isReadable()) {
      SocketChannel socketChannel = (SocketChannel) key.channel();
      ByteBuffer buffer = ByteBuffer.allocate(buffersize);
      int length;
      while((length = socketChannel.read(buffer)) > 0) {
        buffer.flip();
        String msg = decoder.decode(buffer).toString();
        System.out.println(socketChannel.getRemoteAddress() + " said : " + msg);
//        socketChannel.write(encoder.encode(CharBuffer.wrap(msg)));
        buffer.flip();
        socketChannel.write(buffer);
        buffer.clear();
      }
      if(length == -1) {
        key.cancel();
        socketChannel.close();
      }
    }
  }
}
