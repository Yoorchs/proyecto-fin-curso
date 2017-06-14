<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="resources/js/cursos.js"></script>
	
	
	<div class="row">
		<a class="btn btn-info col-xs-1" href= "<c:url value='/cursos/cargar'/>"> CARGAR CSV </a>	
	</div>


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
						<a class="btn col-xs-1 btn-info" href="<c:url value = '/cursos/${curso.codigo}'/>">Editar</a>
						<a class="btn col-xs-1 btn-warning" href="<c:url value = '/cursos/deleteCurso/${curso.codigo}'/>">Borrar</a>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<div>No hay registros en BBDD</div>
			</c:otherwise>
		</c:choose>
	</div>
	<div class="row">
		<a class="btn col-xs-2 btn-info" href="<c:url value = '/cursos/addCurso'/>">Nuevo Curso</a>
	</div>
	<br><br>
	<div>
		<form>
			<div class="row">
				<input type="text" name="buscador" id="buscador" class="col-xs-3">
			</div>
			<div class="row">
				<input type="button" value="Buscar" id="boton" class="btn btn-info col-xs-1">
			</div>
		</form>
	</div>
	
	<div>
		 <table id="tabla" class="table">
		 <thead> RESULTADOS </thead>
			  <tr>
			    <th>Nombre</th>
			    <th>Codigo</th>
			  </tr>
		</table> 
	</div>
	
	
	
