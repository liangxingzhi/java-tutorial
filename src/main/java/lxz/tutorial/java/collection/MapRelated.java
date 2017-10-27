package lxz.tutorial.java.collection;

import java.util.HashMap;
import java.util.Hashtable;

public class MapRelated {

  public static void main(String[] args) {
    testHashTableWithNull();
  }

  public static void testMapWithNull() {
    HashMap<String, String> map = new HashMap<>();
    map.put(null, null);
    System.out.println(map.get(null));
  }

  public static void testHashTableWithNull() {
    Hashtable<String, String> table = new Hashtable<>();
    table.put(null, null);
  }
}
