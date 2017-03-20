package com.somnus.smart.domain;

import java.io.Serializable;
import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DomainProxy implements MethodInterceptor, Serializable {

    private static final long  serialVersionUID = 1L;
    private transient Enhancer enhancer         = new Enhancer();
    private Logger             logger;

    public Object getProxy(Class<?> clazz) {
        logger = LoggerFactory.getLogger(clazz);
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        enhancer.setInterfaces(new Class[] { Serializable.class });
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, 
    		Object[] args, MethodProxy proxy)throws Throwable {
        try {
            Object result = proxy.invokeSuper(obj, args);
            return result;
        } catch (Throwable e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
    }
}