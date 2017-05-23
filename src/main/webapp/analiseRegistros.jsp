<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Avaliar os Registros de Atividade</title>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/lightbox.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/estilo.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lightbox.min.js"></script>
</head>
<body>

	<div class="container-fluid">
		<h1 class="col-md-12 text-center">Avaliação de Certificados</h1>

		<div id="Carrossel" class="carousel slide" data-ride="carousel" data-interval="0">

			<div class="carousel-inner">
			<c:forEach items="${atividades}" var="aluno" varStatus="loop">
				<c:choose>
			      	<c:when test="${loop.index == 0}">
						<div class="item active">
		
							<div class="row nome-aluno">
								<p class="col-md-6">Aluno: <strong>${aluno.nome }</strong></p>
							</div>
							<div class="row caracteristicas">
								<p class="col-md-3 text-center">Data Solicitação: ${aluno.dataSolicitacao }</p>
								<p class="col-md-3 text-center">Categoria: ${aluno.categoria }</p>
								<p class="col-md-3 text-center">Atividade: ${aluno.tipoAtividade }</p>
								<p class="col-md-3 text-center">Carga-horária: ${aluno.cargaHoraria }</p>
							</div>
							<div class="row botoes">
								<form method="post" action="${pageContext.request.contextPath}/analiseAtividades/homeAnalise/aprovar/${aluno.id}">
									<div class="col-md-1 col-md-offset-1">
										<button type="submit" class="btn btn-primary">Aprovar</button>
									</div>
								</form>
								<form method="post" action="${pageContext.request.contextPath}/analiseAtividades/homeAnalise/recusar/${aluno.id}">
									<div class="col-md-1">
										<button type="submit" class="btn btn-danger">Recusar</button>
									</div>
									<div class="col-md-8">
										<input class="form-control" type="text" placeholder="Justifique a recusa" name="justificativa" id="justificativa" required />
									</div>
								</form>
							</div>
							
							<div class="row text-center">
								<c:if test="${aluno.contentType == 'application/pdf'}">
									 <!-- TESTAR O DOCUMENTO SE FOR PDF USAR ABAIXO -->
									<iframe src = "${pageContext.request.contextPath}/ViewerJS/#../upload/${aluno.nomeArquivo}" width='100%' height='800' allowfullscreen webkitallowfullscreen>
									</iframe>
								</c:if>
								<c:if test="${aluno.contentType == 'image/jpg' || aluno.contentType == 'image/png'}">
									<!-- E SE FOR JPG PNG ABRIR O ABAIXO -->
									<a class="example-image-link" href="${pageContext.request.contextPath}/upload/${aluno.nomeArquivo}" data-lightbox="example-1">
										<img class="example-image imagem-certificado" src="${pageContext.request.contextPath}/upload/${aluno.nomeArquivo}" />
									</a>
								</c:if>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div class="item">
		
							<div class="row nome-aluno">
								<p class="col-md-6">Aluno: <strong>${aluno.nome }</strong></p>
							</div>
							<div class="row caracteristicas">
								<p class="col-md-3 text-center">Data Solicitação: ${aluno.dataSolicitacao }</p>
								<p class="col-md-3 text-center">Categoria: ${aluno.categoria }</p>
								<p class="col-md-3 text-center">Atividade: ${aluno.tipoAtividade }</p>
								<p class="col-md-3 text-center">Carga-horária: ${aluno.cargaHoraria }</p>
							</div>
							<div class="row botoes">
								<form method="post" action="${pageContext.request.contextPath}/analiseAtividades/homeAnalise/aprovar/${aluno.id}">
									<div class="col-md-1 col-md-offset-1">
										<button type="submit" class="btn btn-primary">Aprovar</button>
									</div>
								</form>
								<form method="post" action="${pageContext.request.contextPath}/analiseAtividades/homeAnalise/recusar/${aluno.id}">
									<div class="col-md-1">
										<button type="submit" class="btn btn-danger">Recusar</button>
									</div>
									<div class="col-md-8">
										<input class="form-control" type="text" placeholder="Justifique a recusa" name="justificativa" id="justificativa" required />
									</div>
								</form>
							</div>
							
							<div class="row text-center">
								<c:if test="${aluno.contentType == 'application/pdf'}">
									 <!-- TESTAR O DOCUMENTO SE FOR PDF USAR ABAIXO -->
									<iframe src = "${pageContext.request.contextPath}/ViewerJS/#../upload/${aluno.nomeArquivo}" width='100%' height='800' allowfullscreen webkitallowfullscreen>
									</iframe>
								</c:if>
								<c:if test="${aluno.contentType == 'image/jpg' || aluno.contentType == 'image/png'}">
									<!-- E SE FOR JPG PNG ABRIR O ABAIXO -->
									<a class="example-image-link" href="${pageContext.request.contextPath}/upload/${aluno.nomeArquivo}" data-lightbox="example-1">
										<img class="example-image" src="${pageContext.request.contextPath}/upload/${aluno.nomeArquivo}" />
									</a>
								</c:if>
							</div>
		
						</div>
					</c:otherwise>
			    </c:choose> 
			</c:forEach>
			</div>

			<a class="left carousel-control" href="#Carrossel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span>
			</a>
			<a class="right carousel-control" href="#Carrossel" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right"></span>
			</a>

		</div>
	</div>
</body>
</html>