<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="../images/IMG.png">
<form action="updateuser" method="post">
<table border="1" align="center">
<tr>
<td>PWD:</td>
<td><input type="text" name="userPwd" value="${it.userPwd}" /></td>
</tr>
<tr>
<td></td>
<td>
<input type="submit" value="update" />
</td></tr>
</table>
</form>
</body>
</html>