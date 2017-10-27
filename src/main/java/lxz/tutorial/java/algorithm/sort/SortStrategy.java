package lxz.tutorial.java.algorithm.sort;

import java.util.Comparator;
import org.apache.poi.ss.formula.functions.T;

public interface SortStrategy {

  <T extends Comparable<T>> void sort(T[] array);

  void sort(T[] array, Comparator<T> comparator);
}