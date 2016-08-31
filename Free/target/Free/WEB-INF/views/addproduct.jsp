<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="item" commandName="product" method="POST" enctype="multipart/form-data">
<table align="center">
<tr>
<td><h1>ADD PRODUCTS</h1></td>
</tr>
<tr>
<td> PRODUCT Name:</td>
<td><form:input path="pname"></form:input><form:errors path="pname" style="color:red"></form:errors></td>
</tr>
<tr>
<td>Product Des:</td>
<td><form:input path="pdes"></form:input><form:errors path="pdes" style="color:red"></form:errors></td>
</tr>
<tr>
<td><form:select path="category">
<form:option value="fish">fish</form:option>
<form:option value="holy">holy</form:option>
<form:option value="crazy">crazy</form:option>
</form:select>
</td>
</tr>
<tr>
<td>Price:</td>
<td><form:input path="price"></form:input></td>
</tr>
<tr>
<td>Item Image:</td>
<td><input type="file" name="file"/>
</tr>
<tr>
<td><input type="submit" value="AddProduct"></td>
</tr>
</table>
</form:form>
</body>
</html>