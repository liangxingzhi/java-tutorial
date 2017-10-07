package lxz.tutorial.java.designpattern;

/**
 * 在访问者模式（Visitor Pattern）中，我们使用了一个访问者类，它改变了元素类的执行算法。通过这种方式，元素的执行算法可以随着访问者改变而改变。这种类型的设计模式属于行为型模式。根据模式，元素对象已接受访问者对象，这样访问者对象就可以处理元素对象上的操作。
 *
 * 意图：主要将数据结构与数据操作分离。主要解决：稳定的数据结构和易变的操作耦合问题。
 *
 * 最难理解的设计模式
 */
public class VisitorPattern {

  public static void main(String[] args) {

    ComputerPart computer = new Computer();
    computer.accept(new ComputerPartDisplayVisitor());
  }

  interface ComputerPart {
    //动态分派，根据接口指向的对象，调用对象的accept方法，动态分派
    void accept(ComputerPartVisitor computerPartVisitor);
  }

  interface ComputerPartVisitor {

    // visit 实现静态分派，方法重载
    void visit(Computer computer);

    void visit(Mouse mouse);

    void visit(Keyboard keyboard);

    void visit(Monitor monitor);
  }

  static class Keyboard implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
      //静态分派的关键是传入参数的类型
      computerPartVisitor.visit(this);
    }
  }

  static class Monitor implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
      computerPartVisitor.visit(this);
    }
  }

  static class Mouse implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
      computerPartVisitor.visit(this);
    }
  }

  static class Computer implements ComputerPart {

    ComputerPart[] parts;

    public Computer() {
      parts = new ComputerPart[]{new Mouse(), new Keyboard(), new Monitor()};
    }


    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
      for (int i = 0; i < parts.length; i++) {
        parts[i].accept(computerPartVisitor);
      }
      computerPartVisitor.visit(this);
    }
  }

  static class ComputerPartDisplayVisitor implements ComputerPartVisitor {

    @Override
    public void visit(Computer computer) {
      System.out.println("Displaying Computer.");
    }

    @Override
    public void visit(Mouse mouse) {
      System.out.println("Displaying Mouse.");
    }

    @Override
    public void visit(Keyboard keyboard) {
      System.out.println("Displaying Keyboard.");
    }

    @Override
    public void visit(Monitor monitor) {
      System.out.println("Displaying Monitor.");
    }
  }
}
