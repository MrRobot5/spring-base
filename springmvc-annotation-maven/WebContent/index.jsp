<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
		${requestScope.a} <br/>
		${sessionScope.a} <br/>
		${sessionScope.c} <br/>
		${requestScope.user.uname} <br/>
		${requestScope.uu.uname} <br/>
  </body>
</html>
