/*
 * Copyright 2010 by IPS. Floor 3,Universal Industrial Building,
 * Tian Yaoqiao Road 1178,Shanghai, P.R. China，200300. All rights reserved.
 *
 * This software is the confidential and proprietary information of IPS
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with IPS.
 */
package com.somnus.smart.support.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import com.somnus.smart.support.common.Constants;
import com.somnus.smart.support.util.SessionUtil;

/**
 * 日志处理过滤器
 *
 * @author caobin
 * @version 1.0 2012-11-15
 */
public class LoggingProcessFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		//扩展日志追踪号
		MDC.put(Constants.SESSION_ID, SessionUtil.getSessionId());
		try {
			filterChain.doFilter(request, response);
		} finally {
			MDC.clear();
		}

	}
}
