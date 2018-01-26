<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:form action="userInfo0Action!save"  namespace="/ch2"  method="post"  enctype="multipart/form-data">
	<table align="center" border="1">
		<s:textfield label="UserName" name="userInfoForm.username"></s:textfield>
		<s:radio label="Sex"  name="userInfoForm.sex"  list="#{'1':'Male' , '0':'FeMale'}"  value="%{'1'}"></s:radio>
		<s:textfield label="Birthday" name="userInfoForm.birthday"></s:textfield>
		<s:file label="MyFile" name="myfile"></s:file>
		<s:submit></s:submit>
	</table>
</s:form>
</body>
</html>