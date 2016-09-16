<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="osmar" %>

<c:import url="/WEB-INF/jsp/header.jsp"/>

<form action="${linkTo[HoraLancadaController].adiciona(null)}" method="post">

    <label for="data">Data:</label>
    <div class = "input-group">
	    <input type="text" name="horaLancada.data" id="data" class="form-control"/>
	    <span class = "input-group-addon">dd/mm/yyyy</span>
	</div>
	<osmar:validationMessage name="horaLancada.data"/>
		
	<label for="horaInicial">Hora Inicial:</label>
	<div class = "input-group">
	    <input type="text" pattern="([01]?[0-9]|2[0-3]):[0-5][0-9]" name="horaLancada.horaInicial" id="horaInicial" class="form-control"/>
	    <span class = "input-group-addon">HH:mm</span>
    </div>
    <osmar:validationMessage name="horaLancada.horaInicial"/>
 
   <label for="horaFinal">Hora Final:</label>
   <div class = "input-group">
	    <input type="text" pattern="([01]?[0-9]|2[0-3]):[0-5][0-9]" name="horaLancada.horaFinal" id="horaFinal" class="form-control"/>
	    <span class = "input-group-addon">HH:mm</span>
	</div>
	<osmar:validationMessage name="horaLancada.horaFinal"/>
	
    <label for="comentario">Comentário</label>
    <textarea name="horaLancada.comentario" id="comentario" class="form-control"></textarea>

    <input type="submit" value="Cadastrar" class="btn"/>
</form>
<c:import url="/WEB-INF/jsp/footer.jsp"/>