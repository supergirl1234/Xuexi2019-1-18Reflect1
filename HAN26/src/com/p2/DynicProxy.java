package com.p2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author:Fanleilei
 * Created:2019/3/28 0028
 *
 *
 * 动态代理设计模式
 */
public class DynicProxy {

    public static void main(String[] args) {

        ISubject realsubject=new RealSubject();
        ProxyHandler handler=new ProxyHandler(realsubject);

       ISubject proxyObject= (ISubject)Proxy.newProxyInstance(realsubject.getClass().getClassLoader(),
                new Class[]{ISubject.class},
                handler);

        System.out.println(proxyObject.getClass());
        proxyObject.eat();


    }
}

//ProxyHandler:对真实类的功能进行扩展

/**
 * InvocationHandler 动态代理实现的标识接口，只有实现此接口才具备有动态代理的功能
 */
class ProxyHandler implements InvocationHandler{

    // 绑定任意接口的对象，使用Object描述
    private final Object target;

    public ProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    //括号里的三项参数分别代表：被代理的对象即真实对象，调用的方法对象，方法中接收的参数
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object retVal;
        System.out.println("真实对象执行之前增强");
        retVal=method.invoke(this.target,args);
        System.out.println("真实对象方法执行之后增强");
        return  retVal;
    }
}
