<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
	 StringBuffer url = request.getRequestURL(); //request 내장 객체 활용
	 out.print("url :"+url.toString()); //out내장 객체 활용
	 out.print("<br>");
%>

</body>
</html>