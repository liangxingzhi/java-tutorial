package lxz.tutorial.java.designpattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class FlightWeightPattern {

  public static void main(String[] args) {
    FlightWeightPattern fp = new FlightWeightPattern();
    PositionFactory pf = fp.new PositionFactory();
    Random random = new Random();
    int i = 0;
    while (i++ < 100) {
      Position ps = pf.getPosition(random.nextInt(5), random.nextInt(5));
      ps.show();
    }
    System.out.println(pf.positions.size());
  }

  class Position {

    private final int x;
    private final int y;

    public Position(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public void show() {
      System.out.println("{x:" + x + ",y:" + y + "}");
    }

  }

  class PositionFactory {

    Map<String, Position> positions = new HashMap<>();

    public Position getPosition(int x, int y) {
      String key = String.valueOf(x) + "," + String.valueOf(y);
      if (positions.get(key) == null) {
        positions.put(key, new Position(x, y));
      }
      return positions.get(key);
    }
  }
}
