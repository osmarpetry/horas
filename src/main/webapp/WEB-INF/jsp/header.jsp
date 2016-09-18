<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Osmar Horas</title>
<link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet" />
<link href="<c:url value='/css/site.css'/>" rel="stylesheet" />
<link href="<c:url value='/css/site.css'/>" rel="stylesheet" />
</head>
<body>
	<header> </header>
	<nav class="navbar navbar-default navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="<c:url value='/' />">Osmar Horas</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav ">
          <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Usuários<span class="caret"></span></a>
              <ul class="dropdown-menu">
				<li><a href="<c:url value='/usuario/lista' />">Usuarios Cadastrados</a></li>
				<li><a href="<c:url value='/usuario/form' />">Cadastrar Usuarios</a></li>
              </ul>
            </li>
          <li class="dropdown">
          	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Horas<span class="caret"></span></a>
            <ul class="dropdown-menu">
				<li><a href="<c:url value='/horaLancada/lista' />">Horas Cadastradas</a></li>
				<li><a href="<c:url value='/horaLancada/form' />">Cadastrar	Horas</a></li>
              </ul>
			</li>
			<li><a href="<c:url value='/horaLancada/relatorioDeHoras' />">Relatório de Horas</a></li>
          </ul>         
          <ul class="nav navbar-nav navbar-right">
			<c:if test="${usuarioLogado.logado}">
				<li><a href="${linkTo[LoginController].desloga() }">Deslogar</a>
			</c:if>
			<c:if test="${!usuarioLogado.logado}">
				<li><a href="${linkTo[LoginController].form() }">Autenticar</a>
			</c:if>          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    
	<div class="container">
		<main class="col-sm-8">