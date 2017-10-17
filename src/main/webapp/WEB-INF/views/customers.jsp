<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Customers</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Customers</h1>
			
 			
 				<div class="pull-left"> <h3>${SpecialBlurb}</h3> </div>
			</div>
 			
				</form>
 			
		</div>
	</section>

	<section class="container">
		<div class="row">
		
		
		<table class="table table-inverse">
  <thead>
  
    <tr>
      <th>#</th>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Email</th>
      <th>Phone #</th>
     
    </tr>
  </thead>
  <tbody>
  
			 <c:forEach items="${customers}" var="customer">
  
    <tr>
      <th scope="row">${customer.id}</th>
    
     
       <td>${customer.firstName}</td>
        <td>${customer.lastName}</td>
      <td>${customer.email}</td>
      <td>${customer.customerNumber}</td>
      <td>
      
      
      
    </tr>
    
    </c:forEach>
    
      </tbody>
</table>
<a href="<spring:url value="/" />" class="btn btn-primary pull-right">Back</a>
		</div>
	</section>
</body>
</html>
