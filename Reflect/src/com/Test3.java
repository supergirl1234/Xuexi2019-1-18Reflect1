package com;

/**
 * Author:Fanleilei
 * Created:2019/1/18 0018
 */

//获得父类信息
    //1.获取Class对象所描述的类的包
    //2.获取Class对象所描述的类的继承的类
    //3.获取Class对象所描述的类的实现的接口
public class Test3 {

    public static void main(String[] args) {
        try {
            Class classes1=Class.forName("com.Test");
           Package package1= classes1.getPackage();
            System.out.print("com.Test的包名");
            System.out.println(package1);

            Class superClass=classes1.getSuperclass();
            System.out.print("com.Test的父类：");
            System.out.println(superClass);

            System.out.print("com.Test的Simple父类：");
            System.out.println(superClass.getSimpleName());


            Class[] interface1=classes1.getInterfaces();
            System.out.print("com.Test的接口");
            for(Class p:interface1){

                System.out.println(p);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

interface Fruit{


}
interface IMessage{


}

class Test extends Test1 implements  Fruit,IMessage{


}