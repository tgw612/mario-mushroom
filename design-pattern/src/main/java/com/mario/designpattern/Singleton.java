package com.mario.designpattern;

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
