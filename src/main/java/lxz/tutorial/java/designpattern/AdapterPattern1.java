package lxz.tutorial.java.designpattern;

/**
 * Convert the interface of a class into another interface clients expect. Adapter lets classes work
 * together, that could not otherwise because of incompatible interfaces.
 *
 * 适配器->类适配器
 */
public class AdapterPattern1 {

  public static void main(String[] args) {
    Adapter adapter = new Adapter();
    adapter.accept220V();
  }


  static interface Target {
    public void accept220V();
  }

  static class Adaptee {
    public void accept110V() {
    }
  }

  static class Adapter extends Adaptee implements Target {
    @Override
    public void accept220V() {
      System.out.println("can accept 220V now");
    }
  }

}
