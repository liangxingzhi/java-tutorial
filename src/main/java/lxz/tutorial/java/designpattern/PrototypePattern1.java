package lxz.tutorial.java.designpattern;

public class PrototypePattern1 {

  public static void main(String[] args) {
    AFieldClass field = new AFieldClass(1000);
    ShallowCopyPrototype shallowCopyPrototype = new ShallowCopyPrototype(field, 2000);
    System.out.println(shallowCopyPrototype);
    try {
      ShallowCopyPrototype shallowCopyPrototype1 = (ShallowCopyPrototype) shallowCopyPrototype.clone();
      System.out.println(shallowCopyPrototype1);

    } catch (CloneNotSupportedException e) {

    }

  }
  static class ShallowCopyPrototype implements Cloneable {

    AFieldClass field;
    Integer j;

    public ShallowCopyPrototype(AFieldClass field, Integer j) {
      this.field = field;
      this.j = j;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
      return super.clone();
    }

    @Override
    public String toString() {
      return super.toString() + " : " + field.toString() + " : " + Integer.toHexString(j.hashCode());
    }
  }

  static class AFieldClass {
    int i;
    public AFieldClass(int i) {
      this.i = i;
    }
  }
}
