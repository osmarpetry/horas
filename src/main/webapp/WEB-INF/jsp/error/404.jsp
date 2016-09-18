<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp"/>

<h1>ERRO 404 - Volte para a <a href="<c:url value='/' />">página inicial</a></h1>
<img src="<c:url value='/img/error.jpg' />" class="img-fluid" alt="Responsive image">


<c:import url="/WEB-INF/jsp/footer.jsp"/>