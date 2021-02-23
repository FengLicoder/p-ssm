package com.lhr.observer_modle;


/**
 * 观察者模式测试类
 */
public class Test {
    public static void main(String[] args) {
        IsObservered isObservered = new IsObservered();
        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();
        isObservered.addList(observer1);
        isObservered.addList(observer2);
        isObservered.sendMessage();
    }


}
