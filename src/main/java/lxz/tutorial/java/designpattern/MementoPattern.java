package lxz.tutorial.java.designpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 备忘录模式（Memento Pattern）保存一个对象的某个状态，以便在适当的时候恢复对象。备忘录模式属于行为型模式。
 */
public class MementoPattern {

  public static void main(String[] args) {
    Originator o = new Originator();
    o.setState("ON");
    CareTaker careTaker = new CareTaker();
    careTaker.add(o.saveToMemento());
    o.setState("OFF");

    o.restoreFromMemento(careTaker.mementoList.get(0));
    System.out.println(o.getState());
  }

  static class Originator {

    String state;

    public String getState() {
      return state;
    }

    public void setState(String state) {
      this.state = state;
    }

    public Memento saveToMemento() {
      return new Memento(state);
    }

    public void restoreFromMemento(Memento m) {
      this.state = m.state;
    }
  }

  static class Memento {

    final String state;

    Memento(String state) {
      this.state = state;
    }
  }

  static class CareTaker {

    List<Memento> mementoList = new ArrayList<>();

    public void add(Memento o) {
      mementoList.add(o);
    }

    public void get(int i) {
      mementoList.get(i);
    }

  }
}
