<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Rooms</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Hotel Services</h1>
				<p></p>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row"> 
		
		<br/><br/><br/>
		<table class="table">
		<tr><th>Service Name <th>Description</th>
			<c:forEach items="${services}" var="service">
			<tr><td>${service.name}<td>${service.description}
        
		
			</c:forEach>
			</table>
			
			
		</div>
	</section>
</body>
</html>
