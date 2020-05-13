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
	try{
		 //JSP의 경우 이미 내장객체를 가지고 있기 때문에 ServletContext를 얻어내서 사용할 필요가 없다
		 int value = (int) application.getAttribute("val");
		value+=2;
		application.setAttribute("val", value);
		
	%>
	
	<h1><%=value %></h1>
	<%
	}catch(NullPointerException ex){
	%>
	
	<h1> 설정된 값이 없습니다.</h1>
	<%
		
	}
	%>	
	
</body>
</html>