<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%@ page isELIgnored="false"%>  <!--  EL 무시하고싶을 떄 true로 하면됨-->
 <%
 	request.setAttribute("k", 10); //정수형 데이터
  
  	request.setAttribute("m", true); //boolean 데이터
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
		k : ${k}<br>
		
		k+5 :${k+5 }<br>  
		k+5 :${k-5 }<br> 
		k+5 :${k*5 }<br> 
		k+5 :${k div 5 }<br> 
		
		<p>
		k:${k}<br>
		m:${m}<br>
		
		k > 5:${k>5 }<br>
		k < 5:${k < 5 }<br>
		k <= 10:${k <= 10 }<br>
		k >= 10:${k >= 10}<br>
		
		m:${m }<br>
		!m:${!m }<br>
		
			
</body>
</html>