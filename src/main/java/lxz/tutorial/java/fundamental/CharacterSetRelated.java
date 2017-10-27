package lxz.tutorial.java.fundamental;

import java.io.UnsupportedEncodingException;

public class CharacterSetRelated {

  public static void main(String[] args) {
    String s = "你好";
    try {
      byte[] bytes = s.getBytes("gb2312");
      String newEncodedString = new String(bytes, "iso-8859-1");
      System.out.println(new String(newEncodedString.getBytes("iso-8859-1"),"gb2312"));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }

}
