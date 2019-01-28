package com;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
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
        // （包括父类的属性）getFields
        //（只是本类中的） getDeclaredFields
        try {
            Class classes1=Class.forName("com.Person");
            System.out.println("输出Student类的全部属性：");
             //获取全部属性
            Field field1[]=classes1.getFields();//只能获取pulic类型的属性，包括父类的属性
            for(Field p:field1){
                System.out.print(p+" ");

            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println();

        try {
            Class classes2=Class.forName("com.Student");
            System.out.println("输出Person类的全部属性：");
            //获取全部属性
            Field field2[]=classes2.getFields();//只能获取pulic类型的属性,包括父类的属性

            for(Field p:field2){
                System.out.print(p);

            }
            System.out.println();

            //获取特定属性
            Field field3=classes2.getField("number");//获取包括父类中的特定属性，但必须是public的
            System.out.println("获取number属性："+field3);


            Field field4[]=classes2.getDeclaredFields();//获取的所有属性，不管private、public
            System.out.println("输出Person类的本类属性：");
            for(Field p:field4){
                System.out.print(p);

            }
            System.out.println();

            //获取本类的特定属性
            Field field5=classes2.getDeclaredField("telephone");
            System.out.println("获取Student类的telephone属性：");
            System.out.println(field5);

            //set 、get方法，获取属性之后，通过属性.set()、属性.get()来赋值、取值
            //先实例化一个Student对象
            Student student= (Student) classes2.newInstance();
            System.out.println("实例化后的一个信息："+student);
            field5.setAccessible(true);//一定要有
            field5.set(student,"123456789");
            System.out.println("给telephone赋完值后为："+student);
            System.out.println("给telephone赋完值后,telephone为："+field5.get(student));


            //获取属性类型getType
            System.out.println("field5属性的类型为："+field5.getType());
            System.out.println("field5属性的类型为："+field5.getType().getName());
            System.out.println("field5属性的类型为："+field5.getType().getSimpleName());


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


    }
}
class Person{

    private String name;
    public  Integer age;
    public String number;

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

class Student extends Person{

    public String address;
    private String telephone;

    public Student() {
    }

    public Student(String name, Integer age, String address, String telephone) {
        super(name, age);
        this.address = address;
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number='" + number + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}