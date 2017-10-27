package lxz.tutorial.java.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

  private static final int port = 8888;

  public static void main(String[] args) throws IOException {
    accept();
  }

  public static void accept() throws IOException {
    ServerSocket serverSocket = new ServerSocket(port);
    Socket socket;
    while ((socket = serverSocket.accept()) != null) {
      new SocketThread(socket).start();
    }
  }


}

class SocketThread extends Thread {

  final Socket innerSocket;

  public SocketThread(Socket socket) {
    this.innerSocket = socket;
  }

  @Override
  public void run() {
    try (InputStream inputStream = innerSocket.getInputStream();
        OutputStream outputStream = innerSocket.getOutputStream()) {
      System.out.println("new client is connected : " + innerSocket.getRemoteSocketAddress());
      PrintWriter bufferedWriter = new PrintWriter(outputStream);
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
      String line = reader.readLine();
      bufferedWriter.println(line);
      System.out.println(innerSocket.getRemoteSocketAddress() + " said : " + line);
      bufferedWriter.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}