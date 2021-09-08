<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/messages/${id}/new" method="get">

Enter Your Message:<input type="text" name="messageBody" /> <br>
 <br>
TO<input type="text" name="receiver" />	<br>
<button> Message </button>

</form>
</body>
</html>