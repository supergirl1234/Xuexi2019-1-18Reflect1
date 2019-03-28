package com.p2;

/**
 * Author:Fanleilei
 * Created:2019/3/28 0028
 */
public class TestSubject {

    public static void main(String[] args) {
        ISubject realsubject=new RealSubject();
        ProxySubject proxySubject=new ProxySubject(realsubject);
        proxySubject.eat();
    }
}
