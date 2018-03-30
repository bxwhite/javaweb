<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>jsp的Include指令测试</title>
  </head>
  
  <body>
  <%--使用include标签引入引入其它JSP页面--%>
    <%@include file="/jspfragments/head.jsp" %>
    <h1>网页主体内容</h1>
    <%@include file="/jspfragments/foot.jsp" %>
    
     <%-- <jsp:include page="/jspfragments/head.jsp"/>
 	使用jsp:include标签引入资源
 	<jsp:include page="/jspfragments/foot.jsp"/> --%>

   <%--  <%
      pageContext.include("/jspfragments/head.jsp");
    %>
      	//使用pageContext的include方法引入资源
   <%
     pageContext.include("/jspfragments/foot.jsp");
   %> --%>
  </body>
</html>