<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>&nbsp;</p>
	<%
		session.setAttribute("myname", "ek");
		request.setAttribute("mybug", "34");
	%>
<p align="center">

	&lt;%
	session.setAttribute("myname", "ek"); <br>
	request.setAttribute("mybug", "34");
	%&gt;
	<br><br><br>
	
	OGNL:  
				&lt;s:property value="#session.myname"/> <br>
				<s:property value="#session.myname"/> <br><br>
	
	OGNL:  
				&lt;s:property value="#session['myname']"/> <br>
				<s:property value="#session['myname']"/> <br><br>
	
	OGNL:  
				&lt;s:property value="#request['mybug']"/> <br>
				<s:property value="#request['mybug']"/> <br><br>
	
	OGNL for list:
				&lt;s:select label="label"  name="name"  list="$ {list}" value="%{'name2'}" /> <br>
				<s:select label="label"  name="name"  list="{'name1' , 'name2' , 'name3'}"  value="%{'name2'}" /> <br><br>
				
	OGNL for map:
				&lt;s:select label="label"  name="name"  list="#map" value="%{'bar'}" /> <br>
				<s:select label="label"  name="name"  list="#{'foo':'foovalue' , 'bar':'barvalue' }"  value="%{'bar'}" /> <br><br>
				
	OGNL   s:if in , s:else:
				&lt;s:if test=" 'foo'  in {'foo' , 'bar'}">muhahah&lt;/s:if> &nbsp;  &lt;s:else>bbbb&lt;/s:else><br>
				<s:if test=" 'foo'  in {'foo' , 'bar'}">muhahah</s:if><s:else>bbbb</s:else><br><br>
				
				
	OGNL   s:if not in , s:else:
				&lt;s:if test=" 'foo' not in {'foo' , 'bar'}">muhahah&lt;/s:if> &nbsp;  &lt;s:else>bbbb&lt;/s:else><br>
				<s:if test=" 'foo' not in {'foo' , 'bar'}">muhahah</s:if><s:else>bbbb</s:else><br><br>
</p>
</body>
</html>