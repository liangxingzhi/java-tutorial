package lxz.tutorial.java.designpattern;

public class PrototypePattern2 {

  public static void main(String[] args) {
    AFieldClass field = new AFieldClass(1000);
    DeepCopyPrototype shallowCopyPrototype = new DeepCopyPrototype(field, 2000);
    System.out.println(shallowCopyPrototype);
    try {
      DeepCopyPrototype shallowCopyPrototype1 = (DeepCopyPrototype) shallowCopyPrototype.clone();
      System.out.println(shallowCopyPrototype1);

    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }

  }
  static class DeepCopyPrototype implements Cloneable {

    AFieldClass field;
    Integer j;

    public DeepCopyPrototype(AFieldClass field, Integer j) {
      this.field = field;
      this.j = j;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
      DeepCopyPrototype copy = (DeepCopyPrototype)super.clone();
      AFieldClass field = (AFieldClass) copy.field.clone();
      copy.field = field;
      return  copy;
    }

    @Override
    public String toString() {
      return super.toString() + " : " + field.toString() + " : " + Integer.toHexString(j.hashCode());
    }
  }

  static class AFieldClass implements Cloneable{
    int i;
    public AFieldClass(int i) {
      this.i = i;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
      return super.clone();
    }
  }
}
