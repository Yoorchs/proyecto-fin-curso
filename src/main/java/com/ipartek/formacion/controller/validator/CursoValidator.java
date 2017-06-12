package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dbms.persistence.Curso;

public class CursoValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> curso) {
		return Curso.class.equals(curso);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nomCurso", "form.nombreRequerido", "Tiene que introducir el nombre del curso");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codCurso", "form.codigoRequerido", "Tiene que introducir un codigo de curso");
	}
}
