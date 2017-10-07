package lxz.tutorial.java.designpattern;

/**
 * 生产Benz的工厂可以生产奔驰的Truck，也可以生产奔驰的Car，生产volvo的工厂可以生产volvo的car，也可以生产volvo的Truck，
 * 它将同一个系的产品工厂进行抽象，如果产品系修改，需要修改多个类，比如奔驰有一天需要增加一个生产bus的接口，那么抽象工厂与volvo工厂都需要跟着修改
 */
public class AbstractFactoryPattern {

  public static void main(String[] args) {
    VehicleFactory vf = VehicleFactory.getFactory("benz");
    Truck v1 = vf.createTruck();
    v1.show();
    Car v2 = vf.createCar();
    v2.show();
  }

  static interface VehicleFactory {

    static VehicleFactory getFactory(String type) {

      switch (type) {
        case "benz":
          return new BenzFactory();
        case "volvo":
          return new VolvoFactory();
        default:
          return null;
      }
    }

    Truck createTruck();

    Car createCar();

  }

  static class BenzFactory implements VehicleFactory {


    @Override
    public Truck createTruck() {
      return new BenzTruck(6, "benz");
    }

    @Override
    public Car createCar() {
      return new BenzCar(4, "benz");
    }
  }

  static class VolvoFactory implements VehicleFactory {

    @Override
    public Truck createTruck() {
      return new VolvoTruck(6, "volvo");
    }

    @Override
    public Car createCar() {
      return new VolvoCar(4, "volvo");
    }
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

  static class Truck extends Vehicle {

  }

  static class Car extends Vehicle {

  }

  static class BenzCar extends Car {

    public BenzCar(int tyres, String type) {
      setType(type);
      setTyres(tyres);
    }
  }

  static class BenzTruck extends Truck {

    public BenzTruck(int tyres, String type) {
      setType(type);
      setTyres(tyres);
    }
  }

  static class VolvoCar extends Car {

    public VolvoCar(int tyres, String type) {
      setType(type);
      setTyres(tyres);
    }
  }

  static class VolvoTruck extends Truck {

    public VolvoTruck(int tyres, String type) {
      setType(type);
      setTyres(tyres);
    }
  }
}
