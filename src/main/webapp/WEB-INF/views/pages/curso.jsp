<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<body>
	<header>
		<h2>Detalle de Curso</h2>
	</header>
	<form:form action="save" method="post" commandName="curso" class="container-fluid">
		<c:if test="${!empty curso}">
			<form:hidden path="codigo" />
		</c:if>
		<div class="row">
			<form:label class="col-xs-3" cssClass="" path="nomCurso">Nombre del Curso: </form:label>
			<form:input class="col-xs-3" placeholder="Introduce el nombre del curso" path="nomCurso" cssErrorClass="" cssClass="" />
			<form:errors class="col-xs-3" path="nomCurso" cssClass="text-danger" />
		</div>
		<div class="row">
			<form:label class="col-xs-3" path="codCurso">Codigo del curso: </form:label>
			<form:input class="col-xs-3" placeholder="Introduce el codigo del curso" path="codCurso" cssErrorClass="" cssClass="" />
			<form:errors class="col-xs-3" path="codCurso" cssClass="text-danger" />
		</div>
		<c:set var="men" value="Editar"></c:set>
		<c:set var="disable" value=""></c:set>
		<c:if test="${curso.codigo == -1}">
			<c:set var="men" value="Crear"></c:set>
			<c:set var="disable" value="hidden"></c:set>
		</c:if>
		<input type="submit" class="btn btn-default" value="${men}">
		<a class="btn btn-info" href="<c:url value='/cursos'/>"> Volver</a>
	</form:form>
</body>