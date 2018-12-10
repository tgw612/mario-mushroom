package com.mario.designpattern.obverser;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

// 定义一个Observable
public class ObserverDemo extends Observable {
    private Map<String, Long> counterMap = new HashMap<>();

    public void updateCounter(String key, Long value) {
        counterMap.put(key, value);
        setChanged();
        notifyObservers(counterMap);
    }

    public static void main(String[] args) {
        ObserverDemo demo = new ObserverDemo();
        demo.addObserver(new AdminA());
        demo.addObserver(new AdminB());
        demo.updateCounter("request-count", 100l);
    }
}

// Observer
class AdminA implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("adminA: " + arg);
        System.out.println("adminA: ");
    }
}

class AdminB implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("adminB: " + arg);
    }

}