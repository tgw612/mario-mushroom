package com.mario.aop.javassist;

import org.apache.ibatis.javassist.util.proxy.MethodFilter;
import org.apache.ibatis.javassist.util.proxy.MethodHandler;
import org.apache.ibatis.javassist.util.proxy.ProxyFactory;

import java.lang.reflect.Method;

public class JavassitMain2 {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        ProxyFactory factory = new ProxyFactory();
        factory.setSuperclass(JavassistTest.class);
        factory.setFilter(method -> {
            if (method.getName().equals("execxute")) {
                return true;
            }
            return false;
        });

        factory.setHandler(new MethodHandler() {
            @Override
            public Object invoke(Object o, Method method, Method method1, Object[] objects) throws Throwable {
                System.out.println("前置处理");
                Object result= method1.invoke(o,args);
                System.out.println("执行结果:"+result);
                System.out.println("后置处理");
                return result;
            }
        });

        Class<?>c =factory.createClass();
        JavassistTest j = (JavassistTest) c.newInstance();
//        j.execute();
//        System.out.println(j.getProp);
    }
}
