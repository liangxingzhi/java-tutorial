package lxz.tutorial.java.designpattern;

/**
 * 简单工厂模式只有一个工厂，工厂方法可以是静态static的，产品满足开放封闭原则，工厂不满足，新加产品就需要修改工厂代码，如果产品过多，工厂类就会比较臃肿
 */
public class SimpleFactoryPattern {

  public static void main(String[] args) {
    SimpleFactoryPattern sfp = new SimpleFactoryPattern();
    VehicleFactory vf = new VehicleFactory();
    Vehicle car = vf.create("car");
    car.show();

    Vehicle bus = vf.create("bus");
    bus.show();
  }

  static abstract class Vehicle {

    int tyres;
    String type;

    public int getTyres() {
      return tyres;
    }

    public void setTyres(int tyres) {
      this.tyres = tyres;
    }

    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public void show() {
      System.out.println("Type : " + getType() + " With " + getTyres() + " Tires");
    }

  }

  static class Car extends Vehicle {

    public Car(int tyres, String type) {
      setType(type);
      setTyres(tyres);
    }
  }

  static class Bus extends Vehicle {

    public Bus(int tyres, String type) {
      setType(type);
      setTyres(tyres);
    }
  }

  static class VehicleFactory {

    public static Vehicle create(String vehicleType) {
      Vehicle v = null;
      switch (vehicleType) {
        case "car":
          v = new Car(4, "car");
          break;
        case "bus":
          v = new Bus(6, "bus");
          break;
      }
      return v;
    }
  }
}
