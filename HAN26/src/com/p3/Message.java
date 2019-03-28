package com.p3;

import java.util.Arrays;

/**
 * Author:Fanleilei
 * Created:2019/3/28 0028
 */
@InfoAnnotation(name="Jack",skill={"C++","Java"})
public class Message {

    public static void main(String[] args) {
        Class messageClass=Message.class;
        InfoAnnotation annotation= (InfoAnnotation) messageClass.getAnnotation(InfoAnnotation.class);//获取自定义的注解

        System.out.println("name="+annotation.name());
        System.out.println("skill="+Arrays.toString(annotation.skill()));
        System.out.println("age="+annotation.age());
    }
}
