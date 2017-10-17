<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
				<h1>Booking</h1>
				
			</div>
		</div>
	</section>
	<section class="container">
		<form:form  modelAttribute="newCustomer"  class="form-horizontal"  >
			<fieldset>
				<legend>Add new customer</legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div"/>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="customerNum">Phone Number</label>
					<div class="col-lg-10">
						<form:input id="customerNum" path="customerNumber" type="text" class="form:input-large"/>
						<form:errors path="customerNumber" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="firstName">First Name</label>
					<div class="col-lg-10">
						<form:input id="firstName" path="firstName" type="text" class="form:input-large"/>
						<form:errors path="firstName" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="lastName">Last Name</label>
					<div class="col-lg-10">
						<form:input id="lastName" path="lastName" type="text" class="form:input-large"/>
						<form:errors path="lastName" cssClass="text-danger"/>
					</div>
				</div>
			
			
			<div class="form-group">
					<label class="control-label col-lg-2" for="email">email </label>
					<div class="col-lg-10">
						<form:input id="email" path="email" type="text" class="form:input-large"/>
						<form:errors path="email" cssClass="text-danger"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="arrival">Arrival Date </label>
					<div class="col-lg-10">
						<form:input id="arrival" path="rooms[0].arrivalDate" type="text" class="form:input-large"/>
						<form:errors path="rooms[0].arrivalDate" cssClass="text-danger"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="depart">Departure Date </label>
					<div class="col-lg-10">
						<form:input id="depart" path="rooms[0].departureDate" type="text" class="form:input-large"/>
						<form:errors path="rooms[0].departureDate" cssClass="text-danger"/>
					</div>
				</div>
 
 

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Book"/>
						<a href="<spring:url value="/rooms/display/room" />" class="btn btn-primary">Back</a>
					</div>
				</div>
				
				
				
			</fieldset>
		</form:form>
	</section>
</body>
</html>
