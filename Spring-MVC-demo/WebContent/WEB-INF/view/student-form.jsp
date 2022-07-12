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
		
		Favorite Language :
		Java <form:radiobutton path="favoriteLanguage" value="Java" />
		C# <form:radiobutton path="favoriteLanguage" value="C#" />
		Ruby <form:radiobutton path="favoriteLanguage" value="Ruby" />
		PHP <form:radiobutton path="favoriteLanguage" value="PHP" />
		
		<br><br>
		
		Operating System :
		Linux <form:checkbox path="operatingSystem" value="Linux" />
		MS Windows <form:checkbox path="operatingSystem" value="MS Windows" />
		Mac OS <form:checkbox path="operatingSystem" value="Mac OS" />
		
		<br><br>
		
		<input type="submit" value="submit" />
		
	 </form:form>

</body>

</html>