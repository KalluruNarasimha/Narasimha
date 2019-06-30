<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Pwd</title>

</head>
<h2 align="center"><strong>Change password in JSP form</strong></h2>
<body>
<form action="changpwd" method="post" onsubmit="return validatePassWord()">
<table align="center">
<tr>
<td>Old Pass:</td>
<td><input type="password" name="userPwd" value="${it.userPwd}" /></td>
</tr>
<tr>
      <td>&nbsp;</td>
      <td><input type="submit" value="insrt" />
      <input type="reset" value="clean" /></td>
      </tr>  
</table>
</form>
</body>
</html>