package com;

import java.util.Date;

/**
 * Author:Fanleilei
 * Created:2019/1/18 0018
 */
public class Test1 {

    public static void main(String[] args) {
        //1.普通的一个对象，通过java.util.Date这个类实例化的
        Date date=new Date();
        //2.反向操作，反射
        Class classes=date.getClass();
        System.out.println(classes);

        //对象实例化
        //1.new 构造方法  2.反序列化  3.反射
        try {
            Date date1= (Date) classes.newInstance();
            System.out.println(date1);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        //Class对象获取
        //1.object.getClass  2.ClassName.class  3.Class.forName("className");
        //建议：一般在开发反射的代码中我们经常使用类的全限定名
       // Class classes1=java.util.Date.class;
        Class<java.util.Date> classes1=java.util.Date.class;
        System.out.println(classes1);
        try {
            Date date2=classes1.newInstance();
            System.out.println(date2);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Class classes2=null;//这个地方一定要先声明
        try {
            classes2=Class.forName("java.util.Date");
            System.out.println(classes2);
            Date date3= (Date) classes2.newInstance();
            System.out.println(date3);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        //当前这三个Class对象都是有Class<java.util.Date>获取，都来描述java.util.Dtae这个类

        System.out.println(classes==classes1);//true
        System.out.println(classes==classes2);//true
    }
}
