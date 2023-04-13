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
<form:form action="/bank/createForm" method="GET" >
    <label>CLICK CREATE USER BUTTON TO ADD A NEW USER </label>
    <input type="submit" value="createUser">
</form:form>
<form:form action="/bank/checkbalance" method="GET" >
    <label>CLICK CHECK BALANCE BUTTON TO GET BALANCE OF THE USER </label>
    <input type="submit" value="CheckBalance">
</form:form>
<form:form action="/bank/moneytransfer" method="GET" >
    <label>CLICK MONEY TRANSFER BUTTON TO TRANSFER MONEY </label>
    <input type="submit" value="Money Transfer">
</form:form>
</body>
</html>