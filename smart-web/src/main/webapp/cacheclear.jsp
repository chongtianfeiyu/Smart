<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="com.somnus.smart.support.common.*,net.sf.ehcache.*,java.util.*"%>
<%
	String cacheName = request.getParameter("cache");

	String action = request.getParameter("action");

	if (action != null && action.equals("1")) {
		try {
			if (cacheName.equals("all")) {
				CacheManagerUtil.clearAllCache();
				out.print("<script>alert('清理完成')</script>");
			} else {
				CacheManagerUtil.clearCache(cacheName);
				out.print("<script>alert('清理完成')</script>");
			}
		} catch (Exception e) {
			out.print("<script>alert('清理失败')</script>");
		}
	}
%>

<html>
<head>
<title>账务核心系统cache清理</title>
<style type="text/css">
<!--
TD {
	FONT-SIZE: 9pt
}

SELECT {
	FONT-SIZE: 9pt
}

OPTION {
	COLOR: #5040aa;
	FONT-SIZE: 9pt
}

INPUT {
	FONT-SIZE: 9pt
}
-->
</style>
<script>
	function send() {
		var tform = document.getElementById('frm');
		tform.submit();
	}
</script>
</head>
<body bgcolor="#FFFFFF">

	<form action="cacheclear.jsp" method="post" name="frm" id="frm">
		<table width="400" border="1" cellspacing="0" cellpadding="3"
			bordercolordark="#FFFFFF" bordercolorlight="#333333"
			bgcolor="#F0F0FF" align="center">
			<tr bgcolor="#8070FF">
				<td colspan="2">
					<div align="center">
						<font color="#FFFF00"><b>账务核心系统cache清理</b></font>
					</div>
				</td>
			</tr>

			<tr>
				<td>Cache名称</td>
				<td><select name="cache" id="cache" style="width: 150px">
						<%
							out.print("<option value='all'>所有</option>");
							out.print("<option value='cache.bacs.infacctype'>账户类型信息</option>");
							out.print("<option value='cache.bacs.merbasicprdcfg'>商户账户信息</option>");
							out.print("<option value='cache.bacs.infaccentry'>会计科目信息</option>");
							out.print("<option value='cache.bacs.infprdtrantype'>产品交易类型信息</option>");
							out.print("<option value='cache.bacs.infsubdict'>交易科目关系信息</option>");
							out.print("<option value='cache.bacs.meraccount'>商户交易账户信息</option>");
							out.print("<option value='cache.bacs.mermerchant'>商户信息</option>");
						%>
				</select></td>
			</tr>

			<tr>
				<td colspan="2">
					<div align="center">
						<input type="button" value="清理" name="clear" onClick='send()'>
					</div>
				</td>
			</tr>
		</table>
		<input type="hidden" id="action" name="action" value="1">
	</form>
	<hr size="1" noshade width="100%">
	<table align="center" border="0" cellpadding="0" cellspacing="0"
		width="620">
		<tr valign="center">
			<td height="40">
				<p align="center">
					Copyright 2012-2015<a href="http://www.ipayment.com.cn">iPayment.com.cn</a>All
					Rights Reserved.<br> &copy; 版权所有:<a
						href="http://www.ipayment.com.cn" target="_blank">上海环迅电子商务有限公司</a>
				</p>
			</td>
		</tr>
	</table>
</body>
</html>
