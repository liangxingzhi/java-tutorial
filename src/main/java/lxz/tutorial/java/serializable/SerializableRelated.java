package lxz.tutorial.java.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SerializableRelated implements Serializable {

  static final String END_STR = "quit()";
  private String field1;
  private Integer field2;
  private Map<String, String> field3;
  // Object 不可序列化，如果不加上transient关键字，那么序列化过程中就会抛出 ：java.io.NotSerializableException: java.lang.Object
  private transient Object field4;

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    SerializableRelated sr = new SerializableRelated();
    sr.field1 = "haha";
    sr.field2 = Integer.valueOf(10);
    HashMap<String, String> map = new HashMap<>();
    map.put("aa", "aa");
    map.put("bb", "bb");
    sr.field3 = map;
    sr.field4 = new Object();

    /*************************** kick off **********************************/
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    new ObjectOutputStream(baos).writeObject(sr);

    Object deserialization = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))
        .readObject();
    System.out.println(deserialization);
  }


  /**
   * 在序列化和反序列化过程中需要特殊处理的类必须使用下列准确签名来实现特殊方法： enable assert: Run/Debug Configurations -> VM options,
   * readObject 方法负责从流中读取并还原类字段。它可以调用 in.defaultReadObject 来调用默认机制，以还原对象的非静态和非瞬态字段。defaultReadObject
   * 方法使用流中的信息来分配流中通过当前对象中相应命名字段保存的对象的字段。这用于处理类发展后需要添加新字段的情形。该方法本身不需要涉及属于其超类或子类的状态。状态是通过使用
   * writeObject 方法或使用 DataOutput 支持的用于基本数据类型的方法将各个字段写入 ObjectOutputStream 来保存的。 [-ea]
   */
  private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
    ois.defaultReadObject();
    String endString = ois.readUTF();
    assert END_STR.equals(endString);
  }

  /**
   * 在序列化和反序列化过程中需要特殊处理的类必须使用下列准确签名来实现特殊方法： writeObject 方法负责写入特定类的对象的状态，以便相应的 readObject
   * 方法可以还原它。通过调用 out.defaultWriteObject 可以调用保存 Object 的字段的默认机制。该方法本身不需要涉及属于其超类或子类的状态。状态是通过使用
   * writeObject 方法或使用 DataOutput 支持的用于基本数据类型的方法将各个字段写入 ObjectOutputStream 来保存的。
   */
  private void writeObject(ObjectOutputStream ous) throws IOException {
    ous.defaultWriteObject();
    ous.writeUTF(END_STR);
  }

  @Override
  public String toString() {
    return super.toString() + ":" + field1 + ":" + field2 + ":" + field3.toString();
  }
}
