<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="alura" %>

<c:import url="/WEB-INF/jsp/header.jsp"/>

<form action="${linkTo[HoraLancadaController].adiciona(null)}" method="post">
    <label for="data">Data:</label>
    <input type="text" name="horaLancada.data" id="data" class="form-control"/>
    <alura:validationMessage name="horaLancada.data"/>

    <label for="horaInicial">Hora Inicial:</label>
    <input type="text" name="horaLancada.horaInicial" id="horaInicial" class="form-control"/>
    <alura:validationMessage name="horaLancada.horaInicial"/>

    <label for="horaFinal">Hora Final:</label>
    <input type="text" name="horaLancada.horaFinal" id="horaFinal" class="form-control"/>
    <alura:validationMessage name="horaLancada.horaFinal"/>

    <label for="comentario">Comentário</label>
    <textarea name="horaLancada.comentario" id="comentario" class="form-control"></textarea>

    <input type="submit" value="Cadastrar" />
</form>
<c:import url="/WEB-INF/jsp/footer.jsp"/>