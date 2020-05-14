<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<%

	pageContext.setAttribute("p1", "page scope value"); 
	request.setAttribute("r1", "request scope value");
	session.setAttribute("s1", "session scope value");
	application.setAttribute("a1", "application scope value");
%>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

pageContext.getAttribute("p1") : <%=pageContext.getAttribute("p1")%> <br><p>

pageContext.getAttribute("p1") : ${pageScope.p1 } <!--EL표기법이용 --> <br>
	
pageContext.getAttribute("r1") : ${requestScope.r1 } <!--EL표기법이용 --> <br>
pageContext.getAttribute("s1") : ${sessionScope.s1 } <!--EL표기법이용 --> <br>
pageContext.getAttribute("a1") : ${applicationScope.a1 } <!--EL표기법이용 --> <br><p>

pageContext.getAttribute("p1") : ${p1} <!-- 공통된 인자가 없을 경우 이런 방식으로 표현가능 -->	 <br>
pageContext.getAttribute("r1") : ${r1 } <!--EL표기법이용 --> <br>
pageContext.getAttribute("s1") : ${s1 } <!--EL표기법이용 --> <br>
pageContext.getAttribute("a1") : ${a1 } <!--EL표기법이용 --> <br>

</body>
</html>