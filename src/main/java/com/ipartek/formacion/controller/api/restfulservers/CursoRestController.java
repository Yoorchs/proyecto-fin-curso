package com.ipartek.formacion.controller.api.restfulservers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.dbms.persistence.Curso;
import com.ipartek.formacion.service.CursoService;

@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.GET})
@RestController
@RequestMapping(value = "/api/cursos")
public class CursoRestController {
	
	@Inject
	CursoService cS;

	@RequestMapping(value = "/{codCurso}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Curso>> getByCodCurso(@PathVariable("codCurso") String codigo){
		List<Curso> cursos = cS.getByCodigo(codigo);
		ResponseEntity<List<Curso>> response = null;
		if(cursos == null || cursos.isEmpty()){
			response = new ResponseEntity<List<Curso>>(HttpStatus.NO_CONTENT);
		}else{
			response = new ResponseEntity<List<Curso>>(cursos, HttpStatus.OK);
		}
		return response;
	}
	
}
