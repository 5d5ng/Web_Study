<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%-- jsp 주석입니다. 
	it can be used for several lines.
--%>
<!-- html 주석입니다. -->
<%
//자바 주석입니다.
	 for(int i=1;i<=5;i++){
		 
	 
%>
<h<%=i %>>아름다운 한글 </h<%=i %> >
<%
	 }

%>
</body>
</html>