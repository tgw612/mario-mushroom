package com.mario.aop.cglib;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.Enhancer;

public class CglibProxy implements MethodInterceptor {

  private Enhancer enhancer = new Enhancer();

  @Override
  public Object invoke(MethodInvocation methodInvocation) throws Throwable {
    return null;
  }

  public Object getProxy(Class clazz) {
    enhancer.setSuperclass(clazz);
//        enhancer.setCallback(this);
    return enhancer.create();
  }
}
