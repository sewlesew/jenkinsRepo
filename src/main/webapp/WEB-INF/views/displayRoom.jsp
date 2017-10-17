<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Available Rooms </h1>
			</div>
		</div>
	</section>
<div class="container">
    <div class="row">
		<div class="col-md-4 col-md-offset-4">
    		<div class="panel panel-default">
			  
			  	<div class="panel-body">
			 
			  						
				
			    	<form action="<spring:url value="/rooms/display/room"></spring:url>" method="post">
                    <fieldset>
			    	  	<div class="form-group">
			    	  	<label  for="arrival">Arrival Date</label>
			    		    <input id="arrival" class="form:input-large" placeholder="MM/dd/yyyy" name='arrivalDate' type="text">			    				    		
			    			
			    			<label for="departure">Departure Date</label>
			    			<input id="departure" class=" form:input-large" placeholder="MM/dd/yyyy" name='departureDate'  type="text" value="">
			    		    <input class="btn btn-lg btn-success " type="submit" value="Search">
			    		</div>
			    		
			    	</fieldset>
			      	</form>
			      	
			    </div>
			    	
			    	
			    
			</div>
		</div>
	</div>
	
	
<c:if test="${ not empty rooms}">
	<table class="table table-inverse">
  <thead>
  
    <tr>
      <th>#</th>
      <th>RoomNo</th>
      <th>Room Rate</th>
      <th>Room Type</th>
      <th>Bed Type</th>
      <th>Action</th>
    </tr>
  </thead>
  <tbody>
  
  <c:forEach items="${rooms}" var="room">
  
    <tr>
      <th scope="row">${room.id}</th>
    
     
       <td>${room.roomNo}</td>
        <td>${room.roomRate}</td>
      <td>${room.roomType}</td>
      <td>${room.bedType}</td>
      <td>
      
      <form action="<spring:url value="/rooms/room/${room.id}"></spring:url>" method="get">
      <input  type="submit" value="Book">
      </form></td>
      
    </tr>
    
    </c:forEach>
    
    
  </tbody>
</table>
	
	
	
			
	
	
			    		</c:if>
			    		
			    		<a href="<spring:url value="/" />" class="btn btn-primary pull-right">Back</a>
</div>
</body>
