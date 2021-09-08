<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<h1> Profile Page</h1>
<form action="/user/update/name">
   <div class="form-group">
    <label>Name</label>
    <input type="text" class="form-control" name="name" value="${user.getName()}" >
     </div>
      <button type="submit" class="btn btn-primary">Edit</button>
</form>

<form action="/user/update/age">
   <div class="form-group">
    <label>Age</label>
    <input type="text" class="form-control" name="age" value="${user.getAge()}" >
     </div>
      <button type="submit" class="btn btn-primary">Edit</button>
</form>

<h2> Your tweets </h2>
<table border="2" width="70%" cellpadding="2">
	<tr><th>Tweets</th></tr>
<c:forEach items="${tweets}" var="tweets">
    
    <tr>  
         
          <td>${tweets.body}</td>
        
      
    </tr>
 
</c:forEach>
</table>

</body>
</html>
