<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<form action="/messages/${id}/new" method="get">
 <div class="form-group">
    <input type="text" class="form-control" name="messageBody"  placeholder="Enter the message">
  
  </div>
   <div class="form-group">
    <label for="receiver">TO</label>
    <input type="text" class="form-control" name="receiver" placeholder="Receiver Username" >
   
  </div>

<button type="submit" class="btn btn-primary">Message</button>

</form>
</body>
</html>