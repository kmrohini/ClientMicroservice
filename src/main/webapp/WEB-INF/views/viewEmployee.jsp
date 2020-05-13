<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body style="align: center">
	<div align='center'>
		<a href="/">Go back to home Page</a>
		<h2 style="color:blue">Employee List</h2>
		<table border='1' cellpadding="10" style='border-spacing:0px;text-align:center;font-size: 22px;'>
		<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
		</tr>
		<c:forEach var="employee" items="${employeeList}">
			<tr>
				<td>${employee.firstName}</td>
				<td>${employee.lastName}</td>
				<td>${employee.email}</td>
			</tr>
			</c:forEach>
		</table>				
	</div>
</body>
</html>
