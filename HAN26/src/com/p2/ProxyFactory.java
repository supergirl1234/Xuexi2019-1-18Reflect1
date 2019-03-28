package com.p2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Author:Fanleilei
 * Created:2019/3/28 0028
 */
public class ProxyFactory {

    public static Object getInstance(Class realObject,Class proxyObject) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        //实际对象
        Object realSubject=realObject.newInstance();

        //代理类的构造方法
       Constructor constructor=proxyObject.getConstructor(proxyObject.getInterfaces()[0]);//getInterfaces()的返回值类型是Class

        //在只有一个构造方法的情况下，可以这样写
        //Constructor constructor=proxyObject.getConstructors()[0];

        //通过构造方法来创建代理类对象
        Object proxySubject=constructor.newInstance(realSubject);
        return  proxySubject;
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        ISubject subject= (ISubject) ProxyFactory.getInstance(RealSubject.class,ProxySubject.class);
        subject.eat();
    }
}
