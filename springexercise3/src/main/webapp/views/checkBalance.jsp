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
<form:form action="/bank/displayBalance" method="POST" modelAttribute="data">
    UserID:<form:input path="creditID"/><br>
	<input type="submit" value="SUBMIT">
</form:form>
</body>
</html>