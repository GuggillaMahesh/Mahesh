<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    <%@include file="aheader.jsp" %>

  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }    
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
	.carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
  </style>

<center><img src="resources/images/customer.jpg" style="width:300px;height: 300px"></center>
</div>
<div>
<div class="container">
  <div>
  Data:${ss}
    <hr></hr>
    <table class="table table-striped">
    <tr>
    <th>id</th>
    <th>productname</th>
    <th>product description</th>
    <th>category</th>
    <th>price</th>
    <th>image</th>
    </tr>
        <tr>
        <form action="updatemyProduct" method="POST">
             <td><input type="hidden" value="${editproduct.pid}" name="pid"/></td>
            <td><input value="${editproduct.pname}" name="pname"/></td>
            <td><input value="${editproduct.pdes}" name="pdes"/></td>
            <td><input value="${editproduct.category}" name="category"/></td>
            <td><input value="${editproduct.price}" name="price"/></td>
            <td><img src="resources/images/${editproduct.pid}.jpg" style="width:100px;height:100px"></td>
			<td><input type="submit" value="Update"/></td>           
            </form>
        </tr>    
    </table>
</div>

<%@include file="footer.jsp" %>