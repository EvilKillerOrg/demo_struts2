<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<s:head/>
 
</head>
<body>
 <!--s:fielderror--><!--/s:fielderror-->   
<s:form action="loginAction!login"  namespace="/ch1"  method="post" >
	<table align="center" border="1">
		<s:textfield label="UserName" name="loginForm.username" />
	 	<s:password label="Password" name="loginForm.password" />
	 	<s:submit></s:submit> 
	 </table>
</s:form>

</body>
</html>