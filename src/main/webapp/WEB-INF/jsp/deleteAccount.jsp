<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Account</title>
</head>
<body>
	<form:form commandName = "deleteAnAccount">
			<table>
				<tr><td>First Name:</td><td><form:input path = "firstName"  />
				<form:errors path = "firstName" cssClass = "error"/></td></tr>
				<tr><td>Last Name: </td><td><form:input path = "lastName"  />
				<form:errors path = "lastName" cssClass = "error" /></td></tr>
<%-- 				<tr><td>Email: </td><td><form:input path = "email"  /> --%>
<%-- 				<form:errors path = "email" cssClass = "error" /></td></tr> --%>
<%-- 				<tr><td>Password: </td><td><form:password path = "password" /> --%>
<%-- 				<form:errors path = "password" cssClass = "error"/></td></tr> --%>
				<tr> <td></td><td><input type="submit" value = "Submit"></td></tr>
			</table>
	</form:form>
</body>
</html>