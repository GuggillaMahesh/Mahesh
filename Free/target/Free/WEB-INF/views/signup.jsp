<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@include file="header.jsp" %>
welcome to signup page
<form:form action="register" commandName="userobj" method="POST">
<table align="center">
<tr>
<td><h1>Registration form</h1></td>
</tr>
<tr>
<td>UserName:</td>
<td><form:input path="name"></form:input><form:errors path="name" style="color:red"></form:errors></td>
</tr>
<tr>
<td>PassWord:</td>
<td><form:password path="password"></form:password><form:errors path="password" style="color:red"></form:errors></td>
</tr>
<tr>
<td>EmailId:</td>
<td><form:input path="email"></form:input><form:errors path="email" style="color:red"></form:errors></td>
</tr>
<tr>
<td>Mobile Number:</td>
<td><form:input path="mobile"></form:input><form:errors path="mobile" style="color:red"></form:errors></td>
</tr>
<tr>
<td><input type="submit" value="Register"/></td>
</tr>
</table>
</form:form>
<%@include file="footer.jsp" %>
</body>
</html>