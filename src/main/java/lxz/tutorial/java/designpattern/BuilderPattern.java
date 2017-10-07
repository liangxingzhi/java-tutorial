package lxz.tutorial.java.designpattern;

/**
 * 需要注意的就是如果用builder就不要再调用被构造类型的set方法，最好用builder一次性构建完成
 */
public class BuilderPattern {

  public static void main(String[] args) {
    VehicleBuilder vb = new VehicleBuilder();
    Vehicle v = vb.tyres(4).decoration("good").build();
  }

  static class Vehicle {

    int tyres;
    String chassis;
    String engine;
    String transmission;
    String light;
    String decoration;

    public Vehicle(int tyres, String chassis, String engine, String transmission, String light,
        String decoration) {
      this.tyres = tyres;
      this.chassis = chassis;
      this.engine = engine;
      this.transmission = transmission;
      this.light = light;
      this.decoration = decoration;
    }
  }

  static class VehicleBuilder {

    int tyres;
    String chassis;
    String engine;
    String transmission;
    String light;
    String decoration;

    public VehicleBuilder tyres(int tyres) {
      this.tyres = tyres;
      return this;
    }

    public VehicleBuilder chassis(String chassis) {
      this.chassis = chassis;
      return this;
    }


    public VehicleBuilder engine(String engine) {
      this.engine = engine;
      return this;
    }

    public VehicleBuilder transmission(String transmission) {
      this.transmission = transmission;
      return this;
    }

    public VehicleBuilder light(String light) {
      this.light = light;
      return this;
    }

    public VehicleBuilder decoration(String decoration) {
      this.decoration = decoration;
      return this;
    }

    public Vehicle build() {
      return new Vehicle(tyres, chassis, engine, transmission, light,
          decoration);
    }
  }
}
