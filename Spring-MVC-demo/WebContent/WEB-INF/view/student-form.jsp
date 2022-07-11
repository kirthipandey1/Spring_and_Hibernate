<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!Doctype html>
<html>

<body>

	<form:form action="processForm" modelAttribute="student">
		First name : <form:input path="firstName" />
		<br><br>
		Last name : <form:input path="lastName" />
		<br><br>
		
		Country :
		
	  <form:select path="country">
	<!--	<form:option value="Brazil" label="Brazil" />
		<form:option value="France" label="France" />
		<form:option value="Germany" label="Germany" />
		<form:option value="India" label="India" />
		<form:option value="China" label="China" /> -->	
		
		<form:options items="${student.countryOptions}" />
		
		</form:select> 
		
		
		
		<br><br>
		
		<input type="submit" value="submit" />
		
	 </form:form>

</body>

</html>