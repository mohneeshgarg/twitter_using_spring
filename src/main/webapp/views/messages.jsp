<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<h1><a href="/user/${id}/messages/new">New Message</a></h1><br>

<h2>Message Sent</h2><br>
<table border="2" width="70%" cellpadding="2">
	<tr><th>To</th><th>Message</th></tr>
<c:forEach items="${sent}" var="sent">
    
    <tr>  
          <td>1</td>
          <td>${sent.body}</td>
        
      
    </tr>
 
</c:forEach>
</table>
<br>
<h2>Message Received</h2><br>
<table border="2" width="70%" cellpadding="2">
	<tr><th>From</th><th>Message</th></tr>
<c:forEach items="${received}" var="received">

    <tr>      
       <td>1</td>
        <td>${received.body}</td>
        
  
    </tr>
</c:forEach> 
</table>

</body>
</html>