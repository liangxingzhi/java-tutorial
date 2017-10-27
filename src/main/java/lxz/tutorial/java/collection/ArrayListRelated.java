package lxz.tutorial.java.collection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListRelated {

  public static void main(String[] args) {
    testListResize();
  }

  public static void testListResize() {
    ArrayList<Integer> list = new ArrayList<>();
    System.out.println("original size: " + getCapacity(list));
    list.add(10);
    System.out.println("after add 1 element, size: " + getCapacity(list));
    list.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    System.out.println("after add 0-9 element, size: " + getCapacity(list));
  }

  /**
   *
   * @param list
   * @param <T>
   * @return
   */
  private static <T> int getCapacity(ArrayList<T> list) {
    int result = -1;
    try {
      Field objectArray = ArrayList.class.getDeclaredField("elementData");
      objectArray.setAccessible(true);
      Object[] array = (Object[]) objectArray.get(list);
      result = array.length;
    } catch (NoSuchFieldException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
    return result;
  }
}
