package lxz.tutorial.java.designpattern;

/**
 * Convert the interface of a class into another interface clients expect. Adapter lets classes work
 * together, that could not otherwise because of incompatible interfaces. 适配器->对象适配器
 */
public class AdapterPattern2 {

  public static void main(String[] args) {
    Adapter adapter = new Adapter(new Adaptee());
    adapter.accept220V();
  }


  interface Target {

    void accept220V();

  }

  static class Adaptee {

    public void accept110V() {
    }
  }

  static class Adapter implements Target {

    private Adaptee adaptee;

    Adapter(Adaptee adaptee) {
      this.adaptee = adaptee;
    }

    @Override
    public void accept220V() {
      System.out.println("can accept 220V now");
    }

  }

}
