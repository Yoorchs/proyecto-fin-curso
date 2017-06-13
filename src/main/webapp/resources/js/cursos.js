
$( document ).ready(function() {
	const url = "http://localhost:8080/gestioncursos/api/cursos/";
	alert("Acanemore")
	$("#boton").on("click", (function(){
		var parametro = $("#buscador").val();
		var urlParam = url + parametro;
		alert(urlParam);
		$.ajax({
			url : urlParam,
			  dataType : "json",
			  success : function(data) {
				  console.log(data);
				  $("#tabla tr").remove();
				  var cabecera = "<tr><th>Nombre</th><th>Codigo</th></tr>";
				  $("#tabla").append(cabecera);
				  for (var i = 0; i<data.length; i++){
					  var row = "<tr><td>"+ data[i].nomCurso + "</td>" + "<td>"+ data[i].codCurso + "</td></tr>";
					  $("#tabla").append(row);
				  }
			  }
		 });
	}))
});	
