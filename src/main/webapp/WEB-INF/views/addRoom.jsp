<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Rooms</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Rooms</h1>
				<p>Add Room</p>
			</div>
 		</div>
	</section>
	<section class="container">
		<form:form  modelAttribute="newRoom" class="form-horizontal" >
			<fieldset>
				<legend>Add new Room</legend>



				<form:errors path="*" cssClass="alert alert-danger" element="div"/>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="roomNo"><spring:message code="addRoom.form.roomNo.label"/></label>
					<div class="col-lg-10">
						<form:input id="roomNo" path="roomNo" type="text" class="form:input-large"/>
						<form:errors path="roomNo" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="roomRate"><spring:message code="addRoom.form.roomRate.label"/></label>
					<div class="col-lg-10">
						<form:input id="roomRate" path="roomRate" type="text" class="form:input-large"/>
						<form:errors path="roomRate" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="roomType"><spring:message code="addRoom.form.roomType.label"/></label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="roomType" path="roomType" type="text" class="form:input-large"/>
							<form:errors path="roomType" cssClass="text-danger"/>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="bedType"><spring:message code="addRoom.form.bedType.label"/></label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="bedType" path="bedType" type="text" class="form:input-large"/>
							<form:errors path="bedType" cssClass="text-danger"/>
						</div>
					</div>
				</div>


				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
						<a  id="btnAdd" href="<spring:url value="/" />" class="btn btn-primary">Back</a>
						
					</div>
				</div>
				
			</fieldset>
		</form:form>		
		
		
		
	</section>
</body>
</html>
