package lxz.tutorial.java.designpattern;

/**
 * 在模板模式（Template Pattern）中，一个抽象类公开定义了执行它的方法的方式/模板。它的子类可以按需要重写方法实现，但调用将以抽象类中定义的方式进行。这种类型的设计模式属于行为型模式。
 *
 * 对外只暴露一个调用整个流程的接口，并且接口内的步骤是固定的，由子类去实现每个步骤中的行为
 */
public class TemplatePattern {

  public static void main(String[] args) {
    Game game = new Cricket();
    game.play();
    System.out.println();
    game = new Football();
    game.play();
  }

  static abstract class Game {

    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay();

    //模板
    public final void play() {

      //初始化游戏
      initialize();

      //开始游戏
      startPlay();

      //结束游戏
      endPlay();
    }
  }

  //板球
  static class Cricket extends Game {

    @Override
    void endPlay() {
      System.out.println("Cricket Game Finished!");
    }

    @Override
    void initialize() {
      System.out.println("Cricket Game Initialized! ");
    }

    @Override
    void startPlay() {
      System.out.println("Cricket Game Started. Start playing!");
    }
  }

  static class Football extends Game {

    @Override
    void endPlay() {
      System.out.println("Football Game Finished!");
    }

    @Override
    void initialize() {
      System.out.println("Football Game Initialized!");
    }

    @Override
    void startPlay() {
      System.out.println("Football Game Started. Start playing!");
    }
  }
}