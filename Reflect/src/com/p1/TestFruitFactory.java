package com.p1;

/**
 * Author:Fanleilei
 * Created:2019/1/18 0018
 */
public class TestFruitFactory {
    public static void main(String[] args) {
        if(args.length==1){
            String fruitName=args[0];
            Fruit fruit=FruitFactory.getFruit(fruitName);
            fruit.eat();

        }else{

            System.out.println("程序没有输入参数");
        }

    }
}
