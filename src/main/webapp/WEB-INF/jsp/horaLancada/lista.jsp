<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/header.jsp" />

<table class="table table-hover">
	<thead>
		<tr>
			<th>Id</th>
			<th>Data</th>
			<th>Hora Inicial</th>
			<th>Hora Final</th>
			<th>Duração</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach items="${horas}" var="horas">
			<tr>
				<td>${horas.id}</td>
				<td>${horas.data.time}</td>
				<td>${horas.horaInicial}</td>
				<td>${horas.horaFinal}</td>
				<td>${horas.duracao}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<c:import url="/WEB-INF/jsp/footer.jsp" />