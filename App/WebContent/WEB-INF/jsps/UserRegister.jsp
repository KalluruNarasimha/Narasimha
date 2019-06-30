<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table,td{
border-color:#87CEEB;
}
table{
 box-sizing: border-box;
  box-shadow: 0px 2px 2px black;
  background-color:#32CD32;
}

</style>
</head>
<body style="background-color:#GSERf">
<h3 align="center">Welcome to User Register Page!!</h3>
<form action="insertUser" method="post">
<table  align="center">
<tr>
<td>User Id:</td> 
<td><input type="text" name="userId"/></td>
</tr>
<tr>
<td>User Name:</td> 
<td><input type="text" name="userName"/></td>
</tr>
<tr>
<td>User Email:</td>
<td><input type="text" name="userEmail"/></td>
</tr>
<tr>
<td>User Mobile:</td>
<td><input type="text" name="userContact"/></td>
</tr>
<tr>
<td>Address:</td>
<td><textarea name="userAddr"></textarea></td>
</tr>
<tr>
<td></td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" value="Register"/></td>
</tr>
</table>
</form>
${msg}
<center><br/>
<a href="userpwd">Forgot Password?</a>
</center>
</body>
</html>
