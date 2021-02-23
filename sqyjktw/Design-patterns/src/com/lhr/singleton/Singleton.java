package com.lhr.singleton;


//懒汉式单例模式（线程安全）
public class Singleton {
    private static Singleton singleton ;

    public static synchronized Singleton getSingleton(){
        if(singleton==null){
            singleton = new Singleton();
        }
        return singleton;
    }
}
