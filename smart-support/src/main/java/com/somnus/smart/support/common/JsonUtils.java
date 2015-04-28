/*
 * Copyright 2010 by IPS. Floor 3,Universal Industrial Building, 
 * Tian Yaoqiao Road 1178,Shanghai, P.R. China，200300. All rights reserved.
 *
 * This software is the confidential and proprietary information of IPS
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with IPS.
 */
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
