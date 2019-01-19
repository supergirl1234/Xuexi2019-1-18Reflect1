package com;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.activation.ActivationInstantiator;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * Author:Fanleilei
 * Created:2019/1/18 0018
 */

public class Test4 {

    public static void code1(){


        //获取构造方法
        try {
            Class classes1 = Class.forName("com.Person");
            //获取全部的构造方法
            Constructor[] constructor1=classes1.getConstructors();
            System.out.println("Person类全部的构造方法：");
            for(Constructor p:constructor1){
                System.out.println(p);

            }
            //获取某个特定的构造方法
            Constructor constructor2=classes1.getConstructor(String.class);
            System.out.println("Person类的一个参数的构造方法：");
            System.out.println(constructor2);

            Constructor constructor3=classes1.getConstructor(String.class,Integer.class);
            System.out.println("Person类的两个参数的构造方法：");
            System.out.println(constructor3);


            //通过构造函数实例化对象
            //class.newInstance()是无参构造函数

            //获取类的构造函数Constructor,执行构造对象的newInstance（参数...） 来实例化对象
            Person person1= (Person) constructor2.newInstance("张三");
            System.out.println(person1);
            Person person2= (Person) constructor3.newInstance("李四",20);
            System.out.println(person2);
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static void code2(){

        //获取普通方法
        try {
            Class classes1=Class.forName("com.Person");
            //获取全部的普通方法
            Method[] method=classes1.getMethods();
            System.out.println("Person类的全部普通方法");
            for(Method p:method){

                System.out.println(p);

            }

            //获取特定的某个方法getMethod(方法名称，参数类型)，若无参数类型就不写
            Method method1=classes1.getMethod("setName",String.class);

            //调用方法
            Person person1= (Person) classes1.newInstance();
            //invoke(对象，参数);
            method1.invoke(person1,"王五");
            System.out.println(person1);

            Method method2=classes1.getMethod("getName");
            Object object1=method2.invoke(person1);
            System.out.println(object1);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
       //获取属性


    }
}
class Person{

    private String name;
    private  Integer age;

    public Person() {
    }
    public Person(String name) {
        this.name = name;

    }


    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}