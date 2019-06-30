<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="Master.jsp" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
table tr th{
color:white;
background-color:black;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Location data</title>
</head>
<body background="../images/bc.png">
<h1>Welcome To Data</h1>
<table border="1">
<tr>
    <th><th>
   <th>ID</th>
    <th><th>
   <th>Code</th>
   <th>Name</th>
   <th>Type</th>
   <th colspan="2">Operations</th>
</tr>
<c:forEach items="${locs}" var="loc">
<tr>
<td><c:out value="${loc.locId}" /></td>
<td><c:out value="${loc.locCode}" /></td>
<td><c:out value="${loc.locName}" /></td>
<td><c:out value="${loc.locType}" /></td>
<td><a href="deleteLoc?locId=${loc.locId}">
<img src="../images/Delete.png" alt="DELETE" width="20" height="20" />
</a></td>
<td><a href="editLoc?locId=${loc.locId}">
<img src="../images/Update.png" alt="EDIT" width="20" height="20" />
</a></td>
</tr>
</c:forEach>
</table>
<a href="locExcel">Excel Export</a> 
 <a href="locPdf">PDF Export</a>
</body>
</html>
