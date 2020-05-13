<html>
<head>
<script>

	function validate() {
		var firstName = document.forms["employeeForm"]["firstName"].value;
		var email = document.forms["employeeForm"]["email"].value;
		var valid = true;
		if (firstName == "") {
			document.getElementById('nameId').innerText = "First Name is madatory";
			valid = false;
		} else {
			document.getElementById('nameId').innerText = "";
		}
		if (email == "") {
			document.getElementById('emailId').innerText = "Email is madatory";
			valid = false;
		} else {
			document.getElementById('emailId').innerText = "";
		}
		return valid;
	}
</script>
</head>
<body style="align: center">
	<div align='center'>
		<a href="/">Go back to home Page</a>
		<h2 style="color:blue">Employee Form</h2>
		${message}
		<form action='/addEmployee' name='employeeForm' method='post' onsubmit="return validate()">
		<table>
			<tr>
				<td style="font-size:20px"><b>First Name&emsp; </b></td>
				<td><input name="firstName"></input></td>
				<td><label id='nameId' style="color:red"></label></td>
			</tr>
			<tr>
				<td style="font-size:20px"><b>Last Name&emsp; </b></td>
				<td><input name="lastName"></input></td>
			</tr>
			<tr>
				<td style="font-size:20px"><b>Email&emsp; </b></td>
				<td><input name="email"></input></td>
				<td><label id='emailId' style="color:red"></label></td>
			</tr>
			<tr>
				<td style="font-size:20px"></td>
				<td><br/><button type='submit'>Save Employee</button>&emsp;</td>
			</tr>
		</table>		
		</form>
	</div>
</body>
</html>
