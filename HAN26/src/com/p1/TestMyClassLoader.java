package com.p1;

/**
 * Author:Fanleilei
 * Created:2019/3/28 0028
 */
public class TestMyClassLoader {

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("自定义类加载器加载：");
        MyClassLoader myClassLoader=new MyClassLoader();

            Class classes=myClassLoader.loadData("com.p1.Member");
            System.out.println(classes);
            System.out.println(classes.getClassLoader());
            System.out.println(classes.getClassLoader().getParent());
            System.out.println(classes.getClassLoader().getParent().getParent());
            System.out.println(classes.getClassLoader().getParent().getParent().getParent());


        System.out.println("系统类加载器加载Member");
        Class classes2=com.p1.Member.class;
        System.out.println(classes2);
        System.out.println(classes2.getClassLoader());
        System.out.println(classes2.getClassLoader().getParent());
        System.out.println(classes2.getClassLoader().getParent().getParent());
        System.out.println(classes2.getClassLoader().getParent().getParent().getParent());


        //比较两个类相等的前提：必须是由同一个类加载器加载的前提下才有意义。否则，即使两个类来源于同一个Class
        //文件，被同一个虚拟机加载，只要加载他们的类加载器不同，那么这两个类注定不想等。
        System.out.println("两个Class对象是否相等：");
        System.out.println(classes==classes2);//false

    }
}
