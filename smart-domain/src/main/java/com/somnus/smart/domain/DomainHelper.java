package com.somnus.smart.domain;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DomainHelper {
    private static Logger logger = LoggerFactory.getLogger(DomainHelper.class);

    public static Object getDomainInstance(Class clazz) {
        DomainProxy proxy = new DomainProxy();
        return proxy.getProxy(clazz);
    }

    public static void setModelData(Object model, Object domain) {
        try {
            PropertyUtils.copyProperties(model, domain);
        } catch (IllegalAccessException ex) {
            logger.error(ex.getMessage(), ex);
        } catch (InvocationTargetException ex) {
            logger.error(ex.getMessage(), ex);
        } catch (NoSuchMethodException ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

    public static void setDomainData(Object domain, Object model) {
        try {
            PropertyUtils.copyProperties(domain, model);
        } catch (IllegalAccessException ex) {
            logger.error(ex.getMessage(), ex);
        } catch (InvocationTargetException ex) {
            logger.error(ex.getMessage(), ex);
        } catch (NoSuchMethodException ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

    public static void setDomainData(Object domain, Object model, HashMap<String, String> propertyMap) {
        try {
            BeanUtils.copyProperties(domain, model);

            for (String key : propertyMap.keySet()) {
                Object value = PropertyUtils.getProperty(model, propertyMap.get(key));
                PropertyUtils.setProperty(domain, key, value);
            }
        } catch (NoSuchMethodException ex) {
            logger.error(ex.getMessage(), ex);
        } catch (IllegalAccessException ex) {
            logger.error(ex.getMessage(), ex);
        } catch (InvocationTargetException ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

    public static Object addProxy(final Object domain) {
        Object proxy;

        try {
            Class clazz = domain.getClass();
            proxy = getDomainInstance(clazz);
            PropertyUtils.copyProperties(proxy, domain);
        } catch (IllegalAccessException ex) {
            logger.error(ex.getMessage(), ex);
            return null;
        } catch (InvocationTargetException ex) {
            logger.error(ex.getMessage(), ex);
            return null;
        } catch (NoSuchMethodException ex) {
            logger.error(ex.getMessage(), ex);
            return null;
        }

        return proxy;
    }

    public static Object removeProxy(final Object proxy) {
        Object domain;
        
        try {
            Class clazz = proxy.getClass().getSuperclass();
            domain = clazz.newInstance();
            PropertyUtils.copyProperties(domain, proxy);
        } catch (InstantiationException ex) {
            logger.error(ex.getMessage(), ex);
            return null;
        } catch (IllegalAccessException ex) {
            logger.error(ex.getMessage(), ex);
            return null;
        } catch (InvocationTargetException ex) {
            logger.error(ex.getMessage(), ex);
            return null;
        } catch (NoSuchMethodException ex) {
            logger.error(ex.getMessage(), ex);
            return null;
        }

        return domain;
    }
}