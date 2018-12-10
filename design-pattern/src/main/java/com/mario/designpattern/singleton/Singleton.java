package com.mario.designpattern.singleton;

public class Singleton {
    private static class SingletonHolder {
        public static Singleton instatnce = new Singleton();
    }

    private Singleton() {

    }

    public static Singleton newInstatnce() {
        return SingletonHolder.instatnce;
    }
}
