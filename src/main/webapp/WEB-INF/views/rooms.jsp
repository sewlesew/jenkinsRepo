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
				<h1>Rooms</h1>
				<p>All the  rooms</p>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row"> 
		<a href="<spring:url value="/rooms/add" />" class="btn btn-primary pull-right">Add Room</a>
		
		<br/><br/><br/>
		<table class="table"><tr><td>Room Number <td> Bed Type <td> Room Type<td>Room Rate<td>Availability
			<c:forEach items="${rooms}" var="room">
			<tr><td>${room.roomNo}<td>${room.bedType}<td>${room.roomType}<td>${room.roomRate}<td>
        
			
			<c:choose>
    <c:when test="${room.checked==true}">
        NO
       
    </c:when>    
    <c:otherwise>
        
    YES
       
    </c:otherwise>
</c:choose>
			</c:forEach>
			</table>
			
			<a  id="btnAdd" href="<spring:url value="/rooms/add" />" class="btn btn-primary">Home</a>
		</div>
	</section>
</body>
</html>
