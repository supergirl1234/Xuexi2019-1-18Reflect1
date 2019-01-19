package com.p1;

/**
 * Author:Fanleilei
 * Created:2019/1/18 0018
 */
public class FruitFactory {
    public FruitFactory() {

    }
    public static Fruit getFruit(String className){

        try {
            Class c=Class.forName(className);
            return (Fruit) c.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

}
