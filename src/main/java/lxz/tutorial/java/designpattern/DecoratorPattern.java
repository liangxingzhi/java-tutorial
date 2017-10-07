package lxz.tutorial.java.designpattern;

public class DecoratorPattern {

  public static void main(String[] args) {
    Rectangle rectangle = new Rectangle();
    rectangle.draw();

    RedShapeDecorator redShapeDecorator = new RedShapeDecorator(rectangle);
    redShapeDecorator.draw();
  }

  interface Shape {

    void draw();
  }

  static class Rectangle implements Shape {

    @Override
    public void draw() {
      System.out.println("Shape: Rectangle");
    }
  }

  static abstract class ShapeDecorator implements Shape {

    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
      this.decoratedShape = decoratedShape;
    }

    public void draw() {
      decoratedShape.draw();
    }
  }

  static class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
      super(decoratedShape);
    }

    @Override
    public void draw() {
      decoratedShape.draw();
      setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape) {
      System.out.println("Border Color: Red");
    }
  }

  public class Circle implements Shape {

    @Override
    public void draw() {
      System.out.println("Shape: Circle");
    }
  }
}