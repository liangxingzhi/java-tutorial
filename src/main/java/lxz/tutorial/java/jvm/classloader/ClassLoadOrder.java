package lxz.tutorial.java.jvm.classloader;

public class ClassLoadOrder {

}

class ParentTest {
  public static String PARENT_STATIC_FIELD = "父类-静态属性";

  // 父类-静态块
  static {
    System.out.println(PARENT_STATIC_FIELD);
    System.out.println("父类-静态代码块");
  }

  private String parentField = "父类-非静态属性";

  // 父类-非静态块
  {
    System.out.println(parentField);
    System.out.println("父类-非静态代码块");
  }

  public ParentTest() {
    System.out.println("父类—无参构造函数");
  }
}

class InitOderTest extends ParentTest {
  public static String STATIC_FIELD = "子类-静态属性";

  // 静态块
  static {
    System.out.println(STATIC_FIELD);
    System.out.println("子类-静态代码块");
  }

  public String field = "子类-非静态属性";

  // 非静态块
  {
    System.out.println(field);
    System.out.println("子类-非静态代码块");
  }

  public InitOderTest() {
    System.out.println("子类-无参构造函数");
  }

  public static void main(String[] args) {
    Class clazz = InitOderTest.class;
    try {
      clazz.newInstance();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }
}