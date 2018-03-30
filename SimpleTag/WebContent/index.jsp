	<%@ page language="java" pageEncoding="UTF-8" import="java.util.*"%>
<%--在jsp页面中导入自定义标签库 --%>
<%@taglib uri="/simpletag" prefix="gacl" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>用简单标签控制标签体是否执行</title>
  </head>
  
  <body>
  
  <%--在jsp页面中使用自定义标签 demo1标签是带有标签体的，标签体的内容是"孤傲苍狼"这几个字符串--%>
    <gacl:demo1>
        孤傲苍狼1<p/>
    </gacl:demo1>
    
     <gacl:demo2>
        孤傲苍狼2<p/>
    </gacl:demo2>
    
     <gacl:demo3>
         gacl_xdp
     </gacl:demo3>
     
      <h1>孤傲苍狼</h1>
        <%--在jsp页面中使用自定义标签 --%>
        <gacl:demo4/>
        <!-- 这里的内容位于 <gacl:demo4/>标签后面，因此不会输出到页面上 -->
        <h1>白虎神皇</h1>
        
         <gacl:demo5 count="2">
              <h1>孤傲苍狼</h1>
         </gacl:demo5>
         
          <%
           Date d = new Date();
         request.setAttribute("date", d);
       %>
       
       <gacl:demo6 date="${date}"/>
       <hr/>
       <gacl:demo6 date="<%=new Date()%>"/>
  </body>
</html>