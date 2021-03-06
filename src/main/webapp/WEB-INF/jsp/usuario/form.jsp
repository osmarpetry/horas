<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="osmar"%>
<c:import url="/WEB-INF/jsp/header.jsp" />
<form action="${linkTo[UsuarioController].adiciona(null)}" method="post">

	<label for="nome">Nome:</label> <input type="text" id="nome"
		name="usuario.nome" class="form-control" value="${usuario.nome}" />
	<osmar:validationMessage name="usuario.nome" />

	<label for="email">E-mail:</label> <input type="email" id="email"
		name="usuario.email" class="form-control" value="${usuario.email}" />
	<osmar:validationMessage name="usuario.email" />

	<label for="login">Login:</label> <input type="text" id="login"
		name="usuario.login" class="form-control" value="${usuario.login}" />
	<osmar:validationMessage name="usuario.login" />
	<osmar:validationMessage name="usuario_invalido"/>

	<label for="senha">Senha:</label> <input type="password" id="senha"
		name="usuario.senha" class="form-control" />
	<osmar:validationMessage name="usuario.senha" />

	<input type="submit" value="Cadastrar" class="btn" />
</form>
<c:import url="/WEB-INF/jsp/footer.jsp" />