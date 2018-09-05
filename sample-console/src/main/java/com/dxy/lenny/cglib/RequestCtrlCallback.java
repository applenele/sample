package com.dxy.lenny.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author niele
 * @date 2018/9/5
 */
public class RequestCtrlCallback implements MethodInterceptor {


    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        if (method.getName().equals("request")) {
            System.out.println("cglib");
        }

        return methodProxy.invokeSuper(object, args);
    }


    public static void main(String[] args) {

        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(Request.class);
        enhancer.setCallback(new RequestCtrlCallback());
        Request proxy=(Request)enhancer.create();


        proxy.request();
    }
}
