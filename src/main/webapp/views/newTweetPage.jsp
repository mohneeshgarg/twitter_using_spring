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
<form action="save" method="get">
 <div class="form-group">
    <label for="tweet"></label>
    <textarea rows="20" class="form-control" name="tweet" placeholder="Write Your Tweet here"  required></textarea>

  </div>

  <button type="submit" class="btn btn-primary">Send</button>
</form>
</body>
</html>