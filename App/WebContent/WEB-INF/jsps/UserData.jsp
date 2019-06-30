<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="../images/KW.png"><h1>Welcome To Data</h1>
<%@include file="Master.jsp" %>
<table border="1">
<tr>
   <th>ID</th>
   <th>NAME</th>
   <th>EMAIL</th>
   <th>CONTACT</th>
   <th>PWD</th>
   <th>ADDR</th>
   <th colspan="2">OPERETIONS</th>
</tr>
<c:forEach items="${users}" var="user">
<tr>
<td><c:out value="${user.userId}" /></td>
<td><c:out value="${user.userName}" /></td>
<td><c:out value="${user.userEmail}" /></td>
<td><c:out value="${user.userContact}" /></td>
<td><c:out value="${user.userPwd}" /></td>
<td><c:out value="${user.userAddr}" /></td>
<td><a href="deleteuser?userId=${user.userId}">
<img src="../images/Delete.png" alt="DELETE" width="30" height="20" />
</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>