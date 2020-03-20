package com.mario.aop.javassist;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JavassitMain1 {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, IOException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        ClassPool cp = ClassPool.getDefault();
        CtClass clazz = cp.makeClass("com.mario.aop.JavassitMain1.JavassistTest");
        StringBuffer body;
        CtField field = new CtField(cp.get("java.lang.String"), "prop", clazz);
        field.setModifiers(Modifier.PRIVATE);

        clazz.addMethod(CtNewMethod.getter("getProp", field));
        clazz.addMethod(CtNewMethod.setter("setProp", field));
        clazz.addField(field, CtField.Initializer.constant("MyName"));

        CtConstructor ctConstructor = new CtConstructor(new CtClass[]{}, clazz);
        body = new StringBuffer();
        body.append("prop = Myname");
        ctConstructor.setBody(body.toString());
        clazz.addConstructor(ctConstructor);
        CtMethod ctMethod = new CtMethod(CtClass.voidType, "execute", new CtClass[]{}, clazz);

        ctMethod.setModifiers(Modifier.PUBLIC);
        body =new StringBuffer();
        body.append("execute():");
        ctMethod.setBody(body.toString());
        clazz.addMethod(ctMethod);
        clazz.writeFile("../");
        Class<?>c =clazz.getClass();
        Object o =c.newInstance();
        Method method =o.getClass().getMethod(" System.out.println(\"execute():\"+this.prop);",new Class[]{});
        method.invoke(o,new Object[]{});
    }
}
