<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>&nbsp;</p>
 
<p align="center">

	 
 
	
	OGNL:   studentVO.lessonList.{? #this.hours>5}"<br><br>
				 studentVO.lessonList.{? #this.lessonName == 'OGNL' }<br><br>
				 this 指的是 studentVO中 的集合 lessonList<br><br>
				 
				 
	<s:property value="studentVO.studentName"/><br><br>
	
	<s:property value="studentVO.lessonList.{? #this.hours>5}"/><br><br>
	
	<s:property value="studentVO.lessonList.{? #this.lessonName == 'OGNL' }"/><br><br>
	
	 
</p>
</body>
</html>