package com.lhr.singleton;

//单例模式之静态内部类
public class Singleton3 {
    private static  class SingletonHolder{
        private static final Singleton3 INSTENCE = new Singleton3();
    }
    public static final Singleton3 getInstance(){
        return SingletonHolder.INSTENCE;
    }
}
