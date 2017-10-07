package lxz.tutorial.java.designpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 过滤器模式（Filter Pattern）或条件（标准）模式（Criteria Pattern）是一种设计模式， 这种模式允许开发人员使用不同的标准来过滤一组对象，
 * 通过逻辑运算以解耦的方式把它们连接起来。这种类型的设计模式属于结构型模式，它结合多个标准来获得单一标准。
 */
public class CriteriaPattern {

  public static void main(String[] args) {
    List<Person> personList = new ArrayList<>();
    personList.add(new Person(18, Gender.Female));
    personList.add(new Person(28, Gender.Female));
    personList.add(new Person(38, Gender.Female));
    personList.add(new Person(48, Gender.Female));
    personList.add(new Person(18, Gender.Male));
    personList.add(new Person(28, Gender.Male));

    MaleCriteria criteria = new MaleCriteria();
    print(criteria.meetCriteria(personList));

    AndCriteria youngFemaleCriteria = new AndCriteria(new FemaleCriteria(), new YoungCriteria());
    print(youngFemaleCriteria.meetCriteria(personList));
  }

  public static void print(List<Person> list) {
    System.out.println("[");
    list.stream().forEach(p -> {
      System.out.println(p);
    });
    System.out.println("]");
  }

  enum Gender {
    Male, Female;
  }

  interface Criteria<T> {

    public List<T> meetCriteria(List<T> list);
  }

  static class Person {

    // 28岁以下，可以过5.4青年节
    int age;
    Gender gender;

    Person(int age, Gender gender) {
      this.age = age;
      this.gender = gender;
    }

    public boolean isMale() {
      return gender == Gender.Male;
    }

    @Override
    public String toString() {
      return super.toString() + " age:" + age + " gender:" + gender;
    }
  }

  static class YoungCriteria implements Criteria<Person> {

    @Override
    public List<Person> meetCriteria(List<Person> list) {
      return list.stream().filter(m -> m.age <= 28).collect(Collectors.toList());
    }
  }

  static class MaleCriteria implements Criteria<Person> {

    @Override
    public List<Person> meetCriteria(List<Person> list) {
      return list.stream().filter(p -> p.gender == Gender.Male).collect(Collectors.toList());
    }
  }

  static class FemaleCriteria implements Criteria<Person> {

    @Override
    public List<Person> meetCriteria(List<Person> list) {
      return list.stream().filter(p -> p.gender == Gender.Female).collect(Collectors.toList());
    }
  }

  static class AndCriteria implements Criteria<Person> {

    Criteria<Person> left;
    Criteria<Person> right;

    AndCriteria(Criteria<Person> left, Criteria<Person> right) {
      this.left = left;
      this.right = right;
    }

    @Override
    public List<Person> meetCriteria(List<Person> list) {
      return right.meetCriteria(left.meetCriteria(list));
    }
  }
}
