package com.p3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author:Fanleilei
 * Created:2019/3/28 0028
 *
 * 自定义一个Annotation
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface InfoAnnotation {

    String name();
    String[] skill();
    String age() default "23";
}
