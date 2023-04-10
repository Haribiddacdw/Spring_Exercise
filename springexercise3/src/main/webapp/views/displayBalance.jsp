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
<h1>
   Account ID :<%=request.getAttribute("id") %>
</h1>
<h1>
  UserName  : <%=request.getAttribute("username") %>
</h1>
<h1>
   Account Balance :<%=request.getAttribute("balance") %>
</h1>

<form:form action="/bank/menu" method="GET" >
    <input type="submit" value="menu">
</form:form>
</body>
</html>