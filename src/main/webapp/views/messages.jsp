<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><a href="/user/${id}/messages/new">New Message</a></h1><br>

<h2>Message Sent</h2><br>

<c:forEach items="${sent}" var="sent">
    <tr>  
         <td>${sent.id}</td>   
        <td>${sent.body}</td>
      
    </tr>
</c:forEach>
<br>
<h2>Message Received</h2><br>
<c:forEach items="${recieved}" var="received">

    <tr>      
      
        <td>${received.body}</td>
          <td>${received.Id}</td>
  
    </tr>
</c:forEach> 

</body>
</html>