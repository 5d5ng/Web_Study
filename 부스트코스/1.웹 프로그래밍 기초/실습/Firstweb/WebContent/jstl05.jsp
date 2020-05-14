<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <c:import url="http://localhost:8080/Firstweb/jstlValue.jsp" var="urlvalue" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

${urlvalue}
<!--  url읽어오기 -->

</body>
</html>