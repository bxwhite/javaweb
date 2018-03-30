<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
   function showtime()
   {
    var myDate = new Date();
    document.getElementById("time").innerHTML = myDate.getHours()
 + "时" + myDate.getMinutes() + "分"
 + myDate.getSeconds() + "秒" ;
    setTimeout("showtime()",1000);
    }
</script>
  <div id="time">
   <script type="text/javascript">
   		showtime();
   </script>
  </div>
</body>
</html>