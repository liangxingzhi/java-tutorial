package lxz.tutorial.java.proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {

        //功能增强-调用实际对象方法前打印日志
        LogUtil.logBefore();
        
        System.out.println(method.toString());

        Object result = method.invoke(target, args);

        //功能增强-调用实际对象方法后打印日志
        LogUtil.logAfter();

        return result;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread()
                .getContextClassLoader(), target.getClass().getInterfaces(),
                this);
    }
}