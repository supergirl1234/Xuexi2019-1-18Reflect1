package com;

/**
 * Author:Fanleilei
 * Created:2019/3/28 0028
 */
public class TestClassLoader {

    public static void main(String[] args) {

       Class classes=Student.class;

        System.out.println(classes.getClassLoader());//sun.misc.Launcher$AppClassLoader@18b4aac2  应用程序类加载器
        System.out.println(classes.getClassLoader().getParent());//sun.misc.Launcher$ExtClassLoader@4554617c  扩展类加载器
        System.out.println(classes.getClassLoader().getParent().getParent());//null

    }
}

class Student{


}
