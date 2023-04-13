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
  <form:form action="/bank/createUser" method="POST" modelAttribute="user">
	Enter the UserID:<form:input path="id"/><br>
	Enter the UserName:<form:input path="name"/><br>
	Enter the UserBalance:<form:input path="balance"/><br>
	
	<input type="submit" value="SUBMIT">
</form:form>
</body>
</html>