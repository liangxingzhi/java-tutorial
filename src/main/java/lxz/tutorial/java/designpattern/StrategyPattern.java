package lxz.tutorial.java.designpattern;

import java.util.List;

/**
 * 在策略模式（Strategy Pattern）中，一个类的行为或其算法可以在运行时更改。这种类型的设计模式属于行为型模式。 在策略模式中，我们创建表示各种策略的对象和一个行为随着策略对象改变而改变的
 * context 对象。策略对象改变 context 对象的执行算法。 context策略切换通过set方法动态实现， 如果实现动态调用方法就得用if／else了，新加方法就需要改原有的if／else／加上新的条件，
 * 如果用策略封装只需要新加一个策略类的实现，动态set就可以了。
 *
 * 其实策略就是用类封装方法实现方法的传递。
 */
public class StrategyPattern {

  public static void main(String[] args) {
    CompareStrategy<Person> s1 = new CompareHeightStrategy();
    CompareStrategy<Person> s2 = new CompareWeightStrategy();
    Context context = new Context(s1);

    Person p1 = new Person(180, 140);
    Person p2 = new Person(170, 150);

    System.out.println(" p1 > p2 : " + context.executeStrategy(p1, p2));

    context.setStrategy(s2);
    System.out.println(" p1 > p2 : " + context.executeStrategy(p1, p2));

  }


  static class Context {

    public void setStrategy(
        CompareStrategy<Person> strategy) {
      this.strategy = strategy;
    }

    public Context(
        CompareStrategy<Person> strategy) {
      this.strategy = strategy;
    }

    CompareStrategy<Person> strategy;
    public int executeStrategy(Person p1, Person p2) {
      return strategy.doCompare(p1, p2);
    }
  }
  static class Person {
    int height;

    public int getHeight() {
      return height;
    }

    public void setHeight(int height) {
      this.height = height;
    }

    public int getWeight() {
      return weight;
    }

    public void setWeight(int weight) {
      this.weight = weight;
    }

    int weight;

    public Person(int height, int weight) {
      this.height = height;
      this.weight = weight;
    }
  }
  interface CompareStrategy<T> {
    int doCompare(T t1, T t2);
  }

  static class CompareHeightStrategy implements CompareStrategy<Person> {

    @Override
    public int doCompare(Person t1, Person t2) {
      return t1.getHeight() - t2.getHeight();
    }
  }

  static class CompareWeightStrategy implements CompareStrategy<Person> {

    @Override
    public int doCompare(Person t1, Person t2) {
      return t1.getWeight() - t2.getWeight();
    }
  }

}
