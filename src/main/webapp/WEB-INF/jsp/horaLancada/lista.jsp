<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="table-responsive">
<table class="table table-striped">
	<thead>
		<tr>
			<th>#</th>
			<th>Tarefa</th>			
			<th>Dono</th>			
			<th>Data Realizada</th>
			<th>Hora Inicial</th>
			<th>Hora Final</th>
			<th>Duração</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach items="${horas}" var="horas">
			<tr>
				<td>${horas.id}</td>
				<td>${horas.comentario}</td>
				<td>${horas.usuario.nome}</td>				
				<td>${horas.data.time}</td>
				<td>${horas.horaInicial}</td>
				<td>${horas.horaFinal}</td>
				<td>${horas.duracao}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
<c:import url="/WEB-INF/jsp/footer.jsp" />