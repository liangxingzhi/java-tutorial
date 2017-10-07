package lxz.tutorial.java.designpattern;

public class IteratorPattern {

  public static void main(String[] args) {
    CustomList list = new CustomList(new Integer[]{1, 2, 3, 4});
    Iterator iterator = list.interator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

  interface Iterator<T> {

    public boolean hasNext();

    public T next();
  }

  static class CustomList<T> {

    T[] array;

    public CustomList(T[] array) {
      this.array = array;
    }

    public Iterator<T> interator() {
      return new CustomListIterator();
    }

    class CustomListIterator implements Iterator<T> {

      int currentIndex = 0;

      @Override
      public boolean hasNext() {
        return currentIndex < array.length;
      }

      @Override
      public T next() {
        return array[currentIndex++];
      }
    }
  }
}
