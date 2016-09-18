<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="osmar" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Osmar Horas</title>
<link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet" />
<link href="<c:url value='/css/signin.css'/>" rel="stylesheet" />
</head>
<form action="${linkTo[LoginController].autentica(null,null) }" method="post" class="form-signin">
	<osmar:validationMessage name="login_invalido"/>
	
	<input type="text" name="login" id="login" class="form-control" placeholder="Login" autofocus="">
	<input type="password" name="senha" id="senha" class="form-control" placeholder="Senha">
	<button class="btn btn-lg btn-primary btn-block" type="submit">Autenticar</button>
</form>

<c:import url="/WEB-INF/jsp/footer.jsp"/>