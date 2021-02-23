package com.lhr.observer_modle;

public class Observer2 implements ObserverInterface {

    String name = "观察者2号";
    @Override
    public void getMessage(String s) {
        System.out.println(name+"收到了信息，内容是："+s);
    }
}
