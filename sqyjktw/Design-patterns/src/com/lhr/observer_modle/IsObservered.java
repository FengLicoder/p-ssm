package com.lhr.observer_modle;

import java.util.ArrayList;
import java.util.List;

public class IsObservered {
    List<ObserverInterface> list = new ArrayList<>();

    public void addList(ObserverInterface observerInterface){
        list.add(observerInterface);
    }

    public void sendMessage(){
        for (ObserverInterface observerInterface : list) {
            observerInterface.getMessage("被观察者已经发出新的信息！");
        }
    }
}
