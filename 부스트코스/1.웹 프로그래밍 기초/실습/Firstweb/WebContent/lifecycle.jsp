<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
hello~~ 
<%
	System.out.println("jspService()");

%>
<%! //�޼��峪 �ʵ带 �����Ҷ�
	public void jspInit(){
	System.out.println("jspInit()!");
	
	}
	
%>
<%! //�޼��峪 �ʵ带 �����Ҷ�
	public void jspDestroy(){
	System.out.println("jspDestroy()");
	
	}
	
%>
</body>
</html>