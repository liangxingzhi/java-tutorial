package lxz.tutorial.java.proxy;

import java.io.Serializable;

public class UserServiceImpl implements Service, UserService{

    public final void add() {
        System.out.println("-----------add--------------");
    }

    public final void remove() {
        System.out.println("-----------remove-------------");
    }

}