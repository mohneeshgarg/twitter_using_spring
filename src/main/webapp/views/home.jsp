
<!-- ---------------------------------------------------------------------------------------------------------------------------- -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>home</title>
</head>
<body>
<core:if test="${flag==true}" >
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="messages">Messages <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/tweet/new">New Tweet</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/user">Profile</a>
      </li>
        <li class="nav-item">
        <a class="nav-link" href="/logout">Logout</a>
      </li>
      
    
    </ul>
  </div>
</nav>

</core:if>

<core:if test="${flag==false}" >
<div style="text-align:center">
<a href="/login" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">LogIn</a>
<a href="/register" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">SignUp</a>
</div>
<br>

</core:if>

<h1 style="text-align:center;padding:20px">
<table border="2" width="70%" cellpadding="2">
	<tr><th>Tweet</th><th>Owner</th><th>Date</th><th>Time</th></tr>
<c:forEach items="${tweets}" var="tweets">

    <tr>
          <td>${tweets.body}</td>
          <td>${tweets.ownerID}</td>
          <td>${tweets.date}</td>
          <td>${tweets.time}</td>


    </tr>

</c:forEach>
</table>
</h1>
</body>
</html>
