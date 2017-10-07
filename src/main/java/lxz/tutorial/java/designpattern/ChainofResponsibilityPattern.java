package lxz.tutorial.java.designpattern;

public class ChainofResponsibilityPattern {

  public static void main(String[] args) {
    int importantLevel = 1;


    PublicServant president = new President();
    PublicServant stadholder = new Stadholder(president);
    PublicServant mayor = new Mayor(stadholder);

    mayor.handle(importantLevel);


  }

  interface PublicServant {

    public boolean handle(int importantLevel);
  }

  static class Mayor implements PublicServant {

    PublicServant superior;

    Mayor(PublicServant superior) {
      this.superior = superior;
    }

    @Override
    public boolean handle(int importantLevel) {
      if (importantLevel <= 1) {
        System.out.println("handled by mayor");
        return true;
      } else {
        return superior.handle(importantLevel);
      }
    }
  }

  static class Stadholder implements PublicServant {

    PublicServant superior;

    Stadholder(PublicServant superior) {
      this.superior = superior;
    }

    @Override
    public boolean handle(int importantLevel) {
      if (importantLevel <= 2) {
        System.out.println("handled by Stadholder");
        return true;
      } else {
        return superior.handle(importantLevel);
      }
    }
  }

  static class President implements PublicServant {

    President() {
    }

    @Override
    public boolean handle(int importantLevel) {
      if (importantLevel <= 3) {
        System.out.println("handled by President");
        return true;
      } else {
        return false;
      }
    }


  }


}
