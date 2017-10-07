package lxz.tutorial.java.designpattern;

/**
 * 中介者模式（Mediator Pattern）是用来降低多个对象和类之间的通信复杂性。这种模式提供了一个中介类，该类通常处理不同类之间的通信，并支持松耦合，使代码易于维护。中介者模式属于行为型模式。
 */
public class MediatorPattern {

  public static void main(String[] args) {
    HouseOwner houseOwner = new HouseOwner("Ross");
    Renter renter = new Renter("Robert");
    Mediator mediator = new Mediator(houseOwner, renter);
    renter.rent(mediator);
    houseOwner.rentout(mediator);

  }

  static class HouseOwner {

    String name;

    HouseOwner(String name) {
      this.name = name;
    }

    public void rentout(Mediator mediator) {
      System.out.println(name + " Said to Mediator : My house is unleased, we can talk about it");
      mediator.notifyRenter();
    }
  }

  static class Renter {

    String name;

    public Renter(String name) {
      this.name = name;
    }

    public void rent(Mediator mediator) {
      System.out.println(name + " Said to Mediator : I want rent a house");
      mediator.notifyHouseOwner();

    }
  }

  static class Mediator {

    HouseOwner houseOwner;
    Renter renter;

    public Mediator(HouseOwner houseOwner, Renter renter) {
      this.houseOwner = houseOwner;
      this.renter = renter;
    }

    public void notifyHouseOwner() {
      System.out.println(
          "mediator send message from " + renter.name + " to the house owner: " + houseOwner.name);
    }

    public void notifyRenter() {
      System.out.println(
          "mediator send message from " + houseOwner.name + " to the renter " + renter.name);
    }

  }
}
