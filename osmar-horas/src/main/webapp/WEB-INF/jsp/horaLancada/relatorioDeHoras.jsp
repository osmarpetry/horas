<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/header.jsp" />

<c:import url="/WEB-INF/jsp/footer.jsp" />
<table class="table table-hover">
	<thead>
		<tr>
			<th>Data</th>
			<th>Horas Normais</th>
			<th>Horas Extras</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${relatorio.horasPorDia}" var="horas">
			<tr>
				<td>${horas.data.time}</td>
				<td>${horas.horasNormais}</td>
				<td>${horas.horasExtras}</td>
			</tr>
		</c:forEach>
	</tbody>
	
</table>