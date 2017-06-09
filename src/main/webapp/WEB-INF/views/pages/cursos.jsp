<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

	<div class="row">
		<span class="col-xs-2 hidden">Codigo</span> 
		<span class="col-xs-2"> Nombre</span> 
		<span class="col-xs-2"> Codigo Curso</span>
		<span class="col-xs-2"></span> 
	</div>
	<div>
		<c:choose>
			<c:when test="${not empty listadoCursos}">
				<c:forEach var="curso" items="${listadoCursos}">
					<div class="row">
						<span class="col-xs-2 hidden">${curso.codigo}</span>
						<span class="col-xs-2">${curso.nomCurso}</span> 
						<span class="col-xs-2">${curso.codCurso}</span>
						<a class="btn col-xs-2 btn-info" href="<c:url value = '/cursos/${curso.codigo}'/>">Editar</a>
						<a class="btn col-xs-2 btn-warning" href="<c:url value = '/cursos/deleteCurso/${curso.codigo}'/>">Borrar</a>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<div>No hay registros en BBDD</div>
			</c:otherwise>
		</c:choose>
	</div>
	<div>
		<a class="btn col-xs-2 btn-info" href="<c:url value = '/cursos/addCurso'/>">Nuevo Curso</a>
	</div>
	
