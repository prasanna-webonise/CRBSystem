<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body  align="center">

<h2>The List of Users is : </h2>

<table  align="center" border="1">
<tr>
<th>UserID</th><th>User Name</th></tr>
	<c:forEach var="user" items="${userList}">
		 <tr><td><a href="users/${user.id}">${user.id}</a></td><td>${user.name}</td></tr>
	</c:forEach>
	</table>
	

</body>
</html>