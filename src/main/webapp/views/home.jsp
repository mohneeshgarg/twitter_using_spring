<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<core:if test="${flag==true}" >
    <form action="messages" method="GET">
        <button>Messages</button>
    </form>
    <form action="/user/${id}/tweet/new">
        <button>New Tweet</button>
    </form>
    <form action="/user/${id}/profile">
        <button>Profile</button>
    </form>
    <form action="/logout">
        <button>Logout</button>
    </form>
</core:if>
<core:if test="${flag==false}" >
    <h1><a href="/login">LogIn</a></h1><br>
    <h1><a href="/register">Signup</a></h1><br>
</core:if>
<br>
<h1>
All Tweets
</h1>

</body>
</html>