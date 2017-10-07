package lxz.tutorial.java.designpattern;

import java.util.ArrayList;
import java.util.List;

public class CompositePattern {

  public static void main(String[] args) {
    Employee manager = new Employee("M", "product", 50);
    Employee emp1 = new Employee("E1", "product", 20);
    Employee emp2 = new Employee("E2", "product", 20);
    Employee emp3 = new Employee("E3", "product", 20);
    manager.add(emp1);
    manager.add(emp2);
    manager.add(emp3);
    System.out.println(manager);
    manager.getSubordinates().stream().forEach(e -> System.out.println("    " + e));
  }

  static class Employee {
    private String name;
    private String dept;
    private int salary;
    private List<Employee> subordinates;

    //构造函数
    public Employee(String name,String dept, int sal) {
      this.name = name;
      this.dept = dept;
      this.salary = sal;
      subordinates = new ArrayList<Employee>();
    }

    public void add(Employee e) {
      subordinates.add(e);
    }

    public void remove(Employee e) {
      subordinates.remove(e);
    }

    public List<Employee> getSubordinates(){
      return subordinates;
    }

    public String toString(){
      return ("Employee :[ Name : "+ name
          +", dept : "+ dept + ", salary :"
          + salary+" ]");
    }
  }
}
