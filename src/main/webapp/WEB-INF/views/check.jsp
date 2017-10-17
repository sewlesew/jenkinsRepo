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
				<h1>Check In | Check out  </h1>
			</div>
		</div>
	</section>
<div class="container">  


 <div class="row">
		<div class="col-md-8 col-md-offset-2">
    		<div class="panel panel-default">
			  
			  	<div class="panel-body">
			 
			  						
				
			    	<form action="<spring:url value="/customers/check"></spring:url>" method="post">
                    <fieldset> <h3>Search Customer by first and last Name</h3>
			    	  
			    	  	<P><label  for="first">First Name</label>
			    		    <input id="first" class="form:input-large" placeholder="First Name" name='firstName' type="text">			    				    		
			    		</P>
			    		<P>	
			    			<label for="departure">  Last Name</label>
			    			<input id="last" class=" form:input-large" placeholder="Last Name" name='lastName'  type="text" value="">
			    		    </P>
			    		    <input class="btn btn-lg btn-success " type="submit" value="Search">
			    		
			    		
			    	</fieldset>
			      	</form>
			      	
			    </div>
			    	
			    	
			    
			</div>
		</div>
	</div>

	
	
<c:if test="${ not empty customers}">
	<table class="table table-inverse">
  <thead>
  
    <tr>
      <th>#</th>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Book from</th>
      <th>Book To</th>
      <th>Room Number</th>
      <th>Action</th>
    </tr>
  </thead>
  <tbody>
  
  <c:forEach items="${customers}" var="customer">
  
    <tr>
      <th scope="row">${customer.id}</th>
    
     
       <td>${customer.firstName}</td>
        <td>${customer.lastName}</td>
      <td>${customer.rooms[0].arrivalDate}</td>
      <td>${customer.rooms[0].departureDate}</td>
      <td>${customer.rooms[0].roominfo.roomNo}</td>
      <td>
      
      <form action="<spring:url value="/customers/checkin/${customer.id}"></spring:url>" method="get">
    
   <c:choose>
  <c:when test="${customer.rooms[0].arrivalDate<currDate}">
      <input  type="submit" value="Check In" >          
  </c:when>
   
   
  
  
</c:choose> 
<input  type="submit" value="Check In" >  
   </form></td>
   
   

  

     
      
      
     
    <td>
      
      <form action="<spring:url value="/customers/checkout/${customer.id}"></spring:url>" method="get">
   
      <c:choose>
      <c:when test="${customer.rooms[0].arrivalDate>currDate}">
      <input  type="submit" value="Check Out">      
      </c:when>
   
    
   </c:choose> 
   
   <input  type="submit" value="Check Out"> 
      </form></td>       
      
    </tr>
    
    </c:forEach>
    
    
  </tbody>
</table>
	
	
	
			
	
	
			    		</c:if>
			    		
			    		<a href="<spring:url value="/" />" class="btn btn-primary pull-right">Back</a>
</div>
</body>
