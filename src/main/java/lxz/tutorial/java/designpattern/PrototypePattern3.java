package lxz.tutorial.java.designpattern;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PrototypePattern3 {

  public static void main(String[] args) {
    AFieldClass field = new AFieldClass(1000);
    DeepCopyPrototype shallowCopyPrototype = new DeepCopyPrototype(field, 2000);
    System.out.println(shallowCopyPrototype);
    try {
      DeepCopyPrototype shallowCopyPrototype1 = (DeepCopyPrototype) shallowCopyPrototype.deepCopy();
      System.out.println(shallowCopyPrototype1);

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  static class DeepCopyPrototype implements Serializable {

    AFieldClass field;
    Integer j;

    public DeepCopyPrototype(AFieldClass field, Integer j) {
      this.field = field;
      this.j = j;
    }

    @Override
    public String toString() {
      return super.toString() + " : " + field.toString() + " : " + Integer
          .toHexString(System.identityHashCode(j));
    }

    public Object deepCopy() throws IOException, ClassNotFoundException {
      ByteArrayOutputStream os = new ByteArrayOutputStream();
      ObjectOutputStream oos = new ObjectOutputStream(os);
      oos.writeObject(this);

      ByteArrayInputStream in = new ByteArrayInputStream(os.toByteArray());
      ObjectInputStream oi = new ObjectInputStream(in);
      return oi.readObject();
    }
  }

  static class AFieldClass implements Serializable {

    int i;

    public AFieldClass(int i) {
      this.i = i;
    }
  }
}
