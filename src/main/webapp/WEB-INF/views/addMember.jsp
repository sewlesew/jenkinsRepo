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
				<h1>Add Staff Members</h1>
				
			</div>
		</div>
	</section>
	<section class="container">
		<form:form  modelAttribute="newMember" class="form-horizontal"  >
			<fieldset>
				<legend>Add new user</legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div"/>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="memberNumber"> Member Number</label>
					<div class="col-lg-10">
						<form:input id="memberNumber" path="memberNumber" type="text" class="form:input-large"/>
						<form:errors path="memberNumber" cssClass="text-danger"/>
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
					<label class="control-label col-lg-2" for="age">Age</label>
					<div class="col-lg-10">
						<form:input id="age" path="age" type="text" class="form:input-large"/>
						<form:errors path="age" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="title">Title</label>
					<div class="col-lg-10">
						<form:input id="title" path="title" type="text" class="form:input-large"/>
						<form:errors path="title" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="userName">User Name</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="username" path="userCredentials.username" type="text" class="form:input-large"/>
							<form:errors path="userCredentials.username" cssClass="text-danger"/>
						</div>
					</div>
				</div>

	
				<div class="form-group">
					<label class="control-label col-lg-2" for="password">Password</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:password id="password" path="userCredentials.password"  class="form:input-large"/>
							<form:errors path="userCredentials.password" cssClass="text-danger"/>
						</div>
					</div>
				</div>

	
				<div class="form-group">
					<label class="control-label col-lg-2" for="verifyPassword">Verify Password</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:password  path="userCredentials.verifyPassword"  class="form:input-large"/>
							<form:errors path="userCredentials.verifyPassword" cssClass="text-danger"/>
						</div>
					</div>
				</div>

				
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="authority">Group</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
						
						<form:select path="userCredentials.Groups[0].id">
                             <form:option value="1" label="ADMIN"/>
                             <form:option value="2" label="USER"/>
                        </form:select>					
						
							<form:errors path="userCredentials.Groups[0].id" cssClass="text-danger"/>
						</div>
					</div>
				</div>
				
				
 
 							<form:hidden path="userCredentials.enabled" value="TRUE"  />
 

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
						<a href="<spring:url value="/" />" class="btn btn-primary">Back</a>
					</div>
				</div>
				
				
				
			</fieldset>
		</form:form>
	</section>
</body>
</html>
