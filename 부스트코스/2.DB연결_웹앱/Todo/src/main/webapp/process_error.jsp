<%@ page language="java" contentType="text/html; charset=EUC-KR"
pageEncoding="EUC-KR"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN“
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Error Page</title>
</head>
<body>
<TABLE BORDER=5 ALIGN="CENTER">
<TR><TH CLASS="TITLE">
Error </TABLE>
<P>
Following error found:
<I><%= exception %></I>. Stack Trace:
<PRE>
<%@ page import="java.io.*" %>
<% exception.printStackTrace(new PrintWriter(out)); %>
</PRE>
</body>
</html>
<% response.setStatus(HttpServletResponse.SC_OK); %>