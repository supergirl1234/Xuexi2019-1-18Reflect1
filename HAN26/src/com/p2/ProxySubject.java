package com.p2;

/**
 * Author:Fanleilei
 * Created:2019/3/28 0028
 */

//这个是静态的代理模式
public class ProxySubject  implements ISubject{

    private ISubject subject;

    public ProxySubject(ISubject subject) {
        this.subject = subject;
    }


    @Override
    public void eat() {
        this.prepare();
        this.subject.eat();
        this.clear();

    }
    public  void prepare(){
        System.out.println("准备");

    }

    public void clear(){

        System.out.println("清理");
    }
}
