package lxz.tutorial.java.proxy;

public class ProxyTest {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);
        UserService proxy = (UserService) invocationHandler.getProxy();
        proxy.add();
        proxy.remove();
    }
}