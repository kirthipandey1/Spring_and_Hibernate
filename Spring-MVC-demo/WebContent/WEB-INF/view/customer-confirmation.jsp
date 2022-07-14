<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Customer Confirmation Page</title>
</head>
	<body>
		The customer confirmed is : ${customer.firstName} ${customer.lastName}
		<br><br>
		The free passes : ${customer.freePasses}
		<br><br>
		Postal code : ${customer.postalCode}
		<br><br>
		Course code : ${customer.courseCode}
	</body>
</html>