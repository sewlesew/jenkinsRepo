<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Welcome</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				 <h2 align="center"> ${greeting} </h2>
				<p> ${tagline} </p>
			
				
								
				<p> <security:authorize access="isAuthenticated()">
  					Welcome  <security:authentication property="principal.username" />
				</security:authorize>

			</div>	 
			
			
 
				  <div class="container">
 
				  <security:authorize access="isAnonymous()">
     					<a href="<spring:url value='/login' />" class="btn btn-default pull-right"> Login</a>
     					<br>
     				
								<img src="<c:url value='/templates/images/reservation.jpg'/>" width="1000px" height="400"/>
				
				</security:authorize>
				
				
 
		 		<security:authorize access="isAuthenticated()">
		 		
       <a href="<spring:url value='/dologout' />" class="btn btn-default pull-right"> Logout</a>
       <br>

<ul class="nav nav-tabs nav-stacked">
<li role="presentation"><a href="<spring:url value="/services/all" />">Hotel Service [REST]</a></li>
  <li role="presentation"><a href="<spring:url value="/rooms/add" />">Room Management</a></li>
  <li role="presentation"><a href="<spring:url value="/rooms/display/room" />">Room Reservation</a></li>  
  <li role="presentation"><a href="<spring:url value="/members/add" />">User Management</a></li>
  
  <li role="presentation"><a href="<spring:url value="/members" />">Staff Management</a></li>
  
  <li role="presentation"><a href="<spring:url value="/customers" />">Customers Information</a></li>
    <li role="presentation"><a href="<spring:url value="/customers/check" />">Check In | Check Out</a></li>

  <li role="presentation"><a href="<spring:url value="/" />">Calculator</a></li>


</ul>
		 					
		 					
		        </security:authorize>
 
 					 
				</div>	
	 			<div class="pull-left"> <h3>${SpecialBlurb}</h3> </div>
		</div>	
	</section>
	
</body>
</html>
