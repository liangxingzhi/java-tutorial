package lxz.tutorial.java.designpattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 将来自客户端的请求传入一个对象，从而使你可用不同的请求对客户进行参数化。用于“行为请求者”与“行为实现者”解耦，可实现二者之间的松耦合，以便适应变化。 分离变化与不变的因素, Commands
 * are an object-oriented replacement for callbacks.
 */
public class CommandPattern {

  public static void main(String[] args) {
    Chef chef = new Chef();
    Command command = new OrderFoodCommand(chef);
    Waiter waiter = new Waiter();
    waiter.takingOrders(Arrays.asList(command));
    waiter.placeOrder();
  }

  interface Command {
    void execute();
  }


  static class OrderFoodCommand implements Command {
    private Chef chef;
    public OrderFoodCommand(Chef chef) {
      this.chef = chef;
    }
    public void execute() {
      chef.cook();
    }
  }

  static class Chef {
    public void cook() {
      System.out.println("chef is cooking");
    }
  }

  static class Waiter {
    List<Command> commands = new ArrayList<>();
    public void takingOrders(List<Command> newCommands) {
      commands.addAll(newCommands);
    }

    public void placeOrder() {
      commands.stream().forEach(Command::execute);
      commands.clear();
    }
  }


}
