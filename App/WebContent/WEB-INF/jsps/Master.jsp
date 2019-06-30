<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.navbar {
    overflow: hidden;
    background-color: #333;
    font-family: Arial;
}
.navbar a {
    float: left;
    font-size: 16px;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

.dropdown {
    float: left;
    overflow: hidden;
}

.dropdown .dropbtn {
    font-size: 16px;    
    border: none;
    outline: none;
    color: white;
    padding: 14px 16px;
    background-color: inherit;
}

.navbar a:hover, .dropdown:hover .dropbtn {
    background-color: red;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    float: none;
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {
    background-color: #ddd;
}

.dropdown:hover .dropdown-content {
    display: block;
}
</style>

</head>
<body background=".../images/background.png">
<div class="navbar">
  <a href="#home">Home</a>
  
  <!-- Location Menu options -->
  <div class="dropdown">
    <button class="dropbtn">Location 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="regloc">Register</a>
      <a href="getAlllocs">View All</a>
      <a href="locReport">Charts</a>
    </div>
  </div>
  <!-- Location Menu END -->
  
  
  <!-- VENDOR Menu options -->
  <div class="dropdown">
    <button class="dropbtn">Vendor 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="regven">Register</a>
      <a href="getAllvens">View All</a>
      <a href="venReport">Charts</a>
    </div>
    </div>
    <!-- VENDOR Menu options END -->
    
     <!-- CUSTOMER Menu options -->
  <div class="dropdown">
    <button class="dropbtn">Customer
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="regcust">Register</a>
      <a href="getAllcusts">View All</a>
      <a href="custReport">Charts</a>
    </div>
    </div>
    <!-- CUSTOMER Menu options END -->
    <!-- ITEM Menu options -->
  <div class="dropdown">
    <button class="dropbtn">Item
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="regitem">Register</a>
      <a href="getAllitems">View All</a>
    </div>
    </div>
    <!-- ITEM Menu options END -->
    <!-- Document Menu options -->
  <div class="dropdown">
    <button class="dropbtn">Document
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="regdocs">Upload Docs </a>
      <a href="downloadDoc">Download Docs </a>
    </div>
    </div>
    <!-- Document Menu options END -->
    <div class="dropdown">
    <button class="dropbtn">More
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
     <a href="edituser?userId=${user.UserId}">
      Change Pass
     </a>
      <a href="logout">LOGOUT</a>
    </div>
    </div>
    </div>
<div align="center">Current User:${UserName}</div>
</body>
</html>