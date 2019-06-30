<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Location Reg</title>
<style type="text/css">
.error{
color:blue;
}
input{color:blue;}
</style>
<script type="text/javascript">
function resetLocFormErrors(){
	document.getElementById("locCodeError").innerHTML="";
	document.getElementById("locNameError").innerHTML="";
	document.getElementById("locTypeError").innerHTML="";
}
function validateLogRegForm(){
	var codeExp=/^[A-Z]{3,6}$/;
	var nameExp=/^[A-Za-z]{4,8}$/;
	var flag=true;
	resetLocFormErrors();
	if(!document.logRegForm.locCode.value.match(codeExp)){
		document.getElementById("locCodeError").innerHTML="Invalid Code Enterd";
		flag=false;
	}if(!document.logRegForm.locName.value.match(nameExp)){
		document.getElementById("locNameError").innerHTML="Invalid Name Enterd";
		flag=false;
	}if(document.logRegForm.locType[0].checked==false && document.logRegForm.locType[1].checked==false){
		document.getElementById("locTypeError").innerHTML="select any type";
		flag=false;
	}if(flag==false){
		return false;
	}
}

</script>
</head>
<body background="../images/background.png">
<%@include file="Master.jsp" %>
<form action="saveLoc" method="post" name="logRegForm" 
onsubmit="return validateLogRegForm()">
<table align="center">
<tr>
 <td>ID:</td>
 <td><input type="text" name="locId" /></td>
 </tr>
 <tr>
 <td>Code:</td>
 <td><input type="text" name="locCode" /><br>
 <span id="locCodeError" class="error"></span>
 </td>
 </tr>
 <tr>
 <td>Name:</td>
 <td>
 <input type="text" name="locName" /><br>
 <span id="locNameError" class="error"></span>
 </td>
 </tr>
 <tr>
 <td>Type:</td>
 <td><input type="radio" name="locType" value="Urban" />Urban
      <input type="radio" name="locType" value="Rural" />Rural<br>
      <span id="locTypeError" class="error"></span>
      </td>
      </tr>
      <tr>
      <td></td>
      <td><input type="submit" value="insrt" />
      <input type="reset" value="clean" /></td>
      </tr>
      </table>
</form>
${Msg}
<center>
<a href="getAlllocs">View all</a>
</center>
</body>
</html>