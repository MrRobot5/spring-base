<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
    <script type="text/javascript" src="jquery/jquery-1.8.3.js"></script>
    <script type="text/javascript">
	    $(document).ready(function () {
	    	
			$("#toggle-button").on("click", function() {
				$("p").toggle(); // 对p元素调用toggle方法
				
				$.get("user/list.do", function(data){
					$("#display-list").html("total :" + data.length);
					$.each(data, function(i, n){
						$("#display-list").append( "<br/>user #" + i + ": " + n.username );
					});
				});
			});
			
		});
    </script>
  </head>
  
  <body>
	<button id="toggle-button">Toggle</button>
	<p>Hello</p>
	<p style="display:none">Good Bye</p>
	
	<div id="display-list"></div>
  </body>
</html>
