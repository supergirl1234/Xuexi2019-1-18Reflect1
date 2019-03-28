package com;

/**
 * Author:Fanleilei
 * Created:2019/1/28 0028
 */

//ClassLoader
public class Test5 {

    public static void main(String[] args) {
        Class classes1=Test5.class;//Class类的对象
        System.out.println(classes1.getClassLoader());//类加载器
        System.out.println(classes1.getClassLoader().getParent());
        System.out.println(classes1.getClassLoader().getParent().getParent());
    }
}
