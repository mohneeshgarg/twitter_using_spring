<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Form</title>
</head>
<body>
<h2>Add new Student</h2>
<form action="/user/addUser" method="post">

Email:<input type="email" name="userName" /> <br>
Name:<input type="text" name="name" /> <br>
Age:<input type="number" name="age" /> <br>
Password:<input type="password" name="password" />  <br>

<button> Register </button>

</form>
</body>
</html>