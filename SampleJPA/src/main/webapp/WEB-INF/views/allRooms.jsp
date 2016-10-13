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

<h2>The List of Rooms is : </h2>

<table align="center" border="1">
<tr>
<th>RoomID</th><th>FloorNo</th></tr>
	<c:forEach var="room" items="${roomList}">
		 <tr><td><a href="rooms/${room.roomId}">${room.roomId}</a></td><td>${room.floorNo}</td></tr>
	</c:forEach>
	</table>
	

</body>
</html>