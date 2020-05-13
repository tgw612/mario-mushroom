package com.mario.designpattern.adapter;

public class Source {

  public void method() {
    System.out.println("source method");
  }

  public static void main(String[] args) {
    Targetable targetable = new Adapter();
    targetable.method(); // source method
    targetable.newMethod(); // new method
  }
}

interface Targetable {

  void method();

  void newMethod();
}

class Adapter extends Source implements Targetable {

  @Override
  public void newMethod() {
    System.out.println("new method");
  }
}

