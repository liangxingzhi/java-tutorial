package lxz.tutorial.java.designpattern;

import java.util.HashMap;
import java.util.Map;

/**
 * 每一个产品都对应一个生产它的工厂，工厂与产品的关系通过配置完成。工厂和产品满足开闭原则，添加产品就相应添加工厂类，并在配置文件增加对应的配置
 */
public class FactoryMethodPattern {

  public static void main(String[] args) {
    Vehicle car = SystemConfig.getFactory("car").create();
    car.show();
    Vehicle bus = SystemConfig.getFactory("bus").create();
    bus.show();
  }

  static interface VehicleFactory {

    public Vehicle create();
  }

  static class SystemConfig {

    static Map<String, VehicleFactory> map = new HashMap<>();

    static {
      loadConfig();
    }

    public static void add(String type, VehicleFactory factory) {
      map.putIfAbsent(type, factory);
    }

    public static void loadConfig() {
      add("car", new CarFactory());
      add("bus", new BusFactory());
    }

    public static VehicleFactory getFactory(String type) {
      return map.get(type);
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

  static class CarFactory implements VehicleFactory {

    @Override
    public Vehicle create() {
      return new Car(4, "car");
    }
  }

  static class BusFactory implements VehicleFactory {

    @Override
    public Vehicle create() {
      return new Bus(6, "bus");
    }
  }


}
