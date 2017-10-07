package lxz.tutorial.java.designpattern;

/**
 * 注意事项： 1、和适配器模式的区别：适配器模式主要改变所考虑对象的接口，而代理模式不能改变所代理类的接口。 2、和装饰器模式的区别：装饰器模式为了增强功能，而代理模式是为了加以控制。
 */
public class ProxyPattern {

  public static void main(String[] args) throws IllegalAccessException {
    UserService proxy = new UserProxy(new UserServiceImpl());
    int result = proxy.addUser();
    if(result == 1) {
      System.out.println("add user success with right permission");
    }
  }

  interface UserService {

    public int addUser() throws IllegalAccessException;

    public int delUser() throws IllegalAccessException;

    public int updUser() throws IllegalAccessException;
  }

  static class UserServiceImpl implements UserService {

    @Override
    public int addUser() {
      return 1;
    }

    @Override
    public int delUser() {
      return 1;
    }

    @Override
    public int updUser() {
      return 1;
    }
  }

  static class UserProxy implements UserService {

    UserService userService;

    UserProxy(UserService userService) {
      this.userService = userService;
    }

    private boolean checkPermission() {
      return true;
    }

    @Override
    public int addUser() throws IllegalAccessException {
      if (checkPermission()) {
       return userService.addUser();
      } else {
        throw new IllegalAccessException("");
      }
    }

    @Override
    public int delUser() throws IllegalAccessException {
      if (checkPermission()) {
        return userService.delUser();
      } else {
        throw new IllegalAccessException("");
      }
    }

    @Override
    public int updUser() throws IllegalAccessException {
      if (checkPermission()) {
        return userService.updUser();
      } else {
        throw new IllegalAccessException("");
      }
    }
  }

}
