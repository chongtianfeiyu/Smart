package com.somnus.smart.support.common;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JsonUtils
 *
 * @author levis
 * @version 1.0 13-9-29
 */
public class JsonUtils {

    private static ObjectMapper objectMapper;

    static {
        objectMapper=new ObjectMapper();
    }

    public static String toString(Object obj){
    	return com.somnus.rest.core.support.JsonUtils.toString(obj);
        /*try{
            return objectMapper.writeValueAsString(obj);
        }catch (Exception ex){
           throw new RuntimeException(ex);
        }*/
    }

}
