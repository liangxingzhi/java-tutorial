package lxz.tutorial.java.algorithm.sort;

import java.util.Comparator;
import org.apache.poi.ss.formula.functions.T;

public class BubbleSort implements SortStrategy {

  @Override
  public <T extends Comparable<T>> void sort(T[] array) {
    if (array == null || array.length <= 1) {
      return;
    }
    for (int i = 0; i < array.length - 1; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if(array[i].compareTo(array[j]) > 0) {
          T tmp = array[i];
          array[i] = array[j];
          array[j] = tmp;
        }
      }
    }
  }

  @Override
  public void sort(T[] array, Comparator<T> comparator) {

  }
}
