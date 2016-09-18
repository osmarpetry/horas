<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="table-responsive">
<table class="table table-striped">
	<thead>
		<tr>
			<th>#</th>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Login</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${usuarios}" var="usuario">
			<tr>
				<td>${usuario.id}</td>
				<td>${usuario.nome}</td>
				<td>${usuario.email}</td>
				<td>${usuario.login}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<c:import url="/WEB-INF/jsp/footer.jsp" />