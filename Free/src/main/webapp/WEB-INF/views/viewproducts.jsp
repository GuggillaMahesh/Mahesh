

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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    <%@include file="aheader.jsp" %>
<center><img src="resources/images/pro.jpg" style="width:300px;height: 300px"></center>
</div>
<div>
<div class="container">
  <div ng-app="myApp" ng-controller="dataCtrl">
  Data:${ss}
Enter Name/Email ID: <input type="text"  ng-model="search">&nbsp&nbsp<span class="glyphicon glyphicon-search"></span>
    <hr></hr>
    <table class="table table-striped">
    <tr>
    <th>id</th>
    <th>productname</th>
    <th>category</th>
    <th>price</th>
    <th>image</th>
    </tr>
        <tr ng-repeat="resource in names | filter:search">
             <td>{{resource.pid}}</td>
            <td>{{ resource.pname}}</td>
            <td>{{ resource.category}}</td>
            <td>{{ resource.price}}</td>
            <td><img src="resources/images/{{resource.pid}}.jpg" style="width:100px;height:100px"></td>
           <td><a href="deleteItem?pid={{resource.pid}}">Delete</a>
           <td><a href="editProduct?id={{resource.pid}}">Edit</a>
        </tr>    
    </table>
</div>

<script>
angular.module('myApp',[]).controller('dataCtrl',function($scope)
		{
	
		$scope.names=${listofallproducts};
		$scope.orderByMe=function(x)
		{
			$scope.myOrderBy=x;
			}
		});
</script>
<%@include file="footer.jsp"%>