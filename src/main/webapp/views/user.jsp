<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1> Profile Page</h1>
<form action="/user/update/name">
Name <input name="name" value="${user.getName()}">
<button> Edit </button>
</form>
<form action="/user/update/age">
Age <input type="number" name="age" value="${user.getAge()}">
<button> Edit </button>
</form>

<h2> Your tweets </h2>
${tweets}

