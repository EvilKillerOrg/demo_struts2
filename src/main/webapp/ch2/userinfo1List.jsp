<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<br><br>
	
	EL<br>
	<s:iterator value="userInfoList"   var="user" > 
		${user.username }	  ${user.sex }	  ${user.birthday }	 <br>
	</s:iterator>
	
	<br><br>
	
	&lt;s:tag<br>
	<s:iterator value="userInfoList"  > 
		<s:property value="username"/>  <s:property value="sex"/>  <s:property value="birthday"/><br>
	</s:iterator>
	<a href="${pageContext.request.contextPath}/ch2/userInfo1Action!downLoad?uuid=1">file download</a>
</body>
</html>