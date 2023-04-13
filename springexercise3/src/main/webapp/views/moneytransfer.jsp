<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
</head>
<body>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <form:form action="/bank/transfer" method="POST" modelAttribute="data">
	Enter the CreditID:<form:input path="creditID"/><br>
	Enter the DebitID:<form:input path="debitID"/><br>
	Enter the Amount to Transfer:<form:input path="amount"/><br>
	<input type="submit" value="SUBMIT">
	
</form:form>
</body>
</html>