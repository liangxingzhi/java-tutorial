package lxz.tutorial.java.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

  private static final int port = 8888;
  private static final String host = "127.0.0.1";


  public static void main(String[] args) throws IOException {
    Socket socket = new Socket(host, port);
    try (PrintWriter pw = new PrintWriter(
        socket.getOutputStream()); BufferedReader br = new BufferedReader(
        new InputStreamReader(socket.getInputStream()))) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Please input a message : ");
      String msg = scanner.next();
      scanner.close();

      pw.println(msg);
      pw.flush();
      String result = br.readLine();
      System.out.println(result);
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
