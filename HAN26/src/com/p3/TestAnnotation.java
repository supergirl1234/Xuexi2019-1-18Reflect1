package com.p3;

import java.lang.annotation.Annotation;

/**
 * Author:Fanleilei
 * Created:2019/3/28 0028
 */

@Deprecated
@SuppressWarnings(value ={"serial"})
public class TestAnnotation {
    @Deprecated
    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Class classes=TestAnnotation.class;
        Annotation[] annotations=classes.getAnnotations();//获取全部注解
        for(Annotation p:annotations){
            System.out.println(p);
        }
        System.out.println("----------");
        Annotation annotation = classes.getAnnotation(Deprecated.class);//获取某一个注解
        System.out.println(annotation);

        System.out.println("------------");
         for(Annotation t:classes.getMethod("toString").getAnnotations()){//获取某一个方法的注解

             System.out.println(t);
         }

    }
}
