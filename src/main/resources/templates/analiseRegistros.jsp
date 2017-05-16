<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/lightbox.min.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lightbox.min.js"></script>
</head>
<body>
	<div class="container">
		<c:forEach items="${atividades}" var="atividade">
		<div class="row">
			<h1 class="col-md-12 text-center">Avaliação de Certificados</h1>
			<p class="col-md-6">Aluno: ${atividade.nome }</p>
			<p class="col-md-6 text-right">Data: ${dataSolicitacao }</p>
		</div>
		<div class="row">
			<p class="col-md-6">Categoria: ${atividade.categoria }</p>
			<p class="col-md-6">Atividade: ${atividade.atividade }</p>
			<p class="col-md-6 text-right">Carga-horária: ${atividade.cargaHoraria }</p>
		</div>
		<div class="row text-center">
			<a class="btn btn-danger" href="">Recusar</a>
			<a class="btn btn-primary" href="">Aprovar</a>		
		</div>
		
		<div class="row text-center">
			<!--<c:if test="${atividade.contentType == application/pdf}">
				 TESTAR O DOCUMENTO SE FOR PDF USAR ABAIXO
				<iframe src = "${pageContext.request.contextPath}/ViewerJS/#../upload/${atividade.arquivo}" width='100%' height='800' allowfullscreen webkitallowfullscreen>
				</iframe>
			</c:if>
			<c:if test="${atividade.contentType == image/jpg || atividade.contentType == image/png}">-->
				<!-- E SE FOR JPG PNG ABRIR O ABAIXO
				<a class="example-image-link" href="${pageContext.request.contextPath}/upload/${atividade.arquivo}" data-lightbox="example-1">
					<img class="example-image" src="${pageContext.request.contextPath}/upload/${atividade.arquivo}" />
				</a>
			</c:if> -->
			<c:else>
				<p><strong>Erro ao abrir o arquivo</strong></p>
			</c:else>
		</div>
		</c:forEach>
	</div>
</body>
</html>