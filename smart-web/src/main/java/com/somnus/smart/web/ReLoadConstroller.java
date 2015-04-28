package com.somnus.smart.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.somnus.smart.support.log.LogBackConfigLoader;

@Controller
public class ReLoadConstroller {

    public ReLoadConstroller() {
    }

    @RequestMapping(value = "/reload", method = RequestMethod.GET)
    public String myMethod(HttpServletRequest request,HttpServletResponse response) throws Exception {
        String url=this.getClass().getClassLoader().getResource("logback.xml").getPath();
        LogBackConfigLoader.load(url);
        return "result";
    }
}
