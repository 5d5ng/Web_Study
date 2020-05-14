<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import = "java.util.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    
    	List<String> list = new ArrayList<>();
    	list.add("Hello");
    	list.add("World");
    	list.add("!!");    	 	
    	request.setAttribute("list", list);
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${list }" var="item"  begin="1">
	${item } <br>
</c:forEach>


</body>
</html>