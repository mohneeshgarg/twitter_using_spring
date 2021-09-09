
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Register</title>
</head>
<body>
<form action="/user/addUser" method="post">
 <div class="form-group">
    <label>Email </label>
    <input type="email" class="form-control" name="userName" aria-describedby="help" placeholder="Enter email" required>
    <small id="help" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  <div class="form-group">
    <label >Password</label>
    <input type="password" class="form-control" name="password" placeholder="Password" required>
  </div>
    <div class="form-group">
    <label>Name</label>
    <input type="text" class="form-control" name="name" placeholder="Enter your name" required>
  </div>
    <div class="form-group">
    <label>Age</label>
    <input type="number" class="form-control" age="age" placeholder="Enter your age" required>
  </div>

  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
