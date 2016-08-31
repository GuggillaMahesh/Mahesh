<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 50%;
	margin: auto;
}

h1 {
	left: 0;
	line-height: 100px;
	margin: auto;
	margin-top: -100px;
	position: absolute;
	top: 15%;
	width: 100%;
	text-align: center;
}

h1 {
	font-family: 'MyWebFont', Fallback, sans-serif;
	font-size: 70;
	color: red;
}

</style>
	<%@include file="header.jsp" %>
	<marquee>
		<h6>ultimate collection mens t-shrits</h6>
	</marquee>
		<div class="container">
		<br>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src=<c:url value="/resources/images/bg12.jpg"/> style= "width="460" height="345" ">
				</div>

				<div class="item">
					<img src=<c:url value="/resources/images/c2.jpg"/> alt="Chania" width="460" height="345">
				</div>

				<div class="item">
					<img src=<c:url value="/resources/images/bbg.jpg"/> alt="Flower" width="460" height="345">
				</div>



				<a class="left carousel-control" href="#myCarousel" role="button"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel" role="button"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
			<br>
<br>
<div align="center">
<img src=<c:url value="/resources/images/f5.jpg"/> alt="Image 6" height="200" width="150"></a>
<img src=<c:url value="/resources/images/f8.jpg"/> alt="Image 7" height=200 width=150></a>
<img src=<c:url value="/resources/images/f9.jpg"/> alt="Image 8" height=200 width=150></a>
</div>
			<div align="center">

</div>
			<%@include file="footer.jsp" %>
