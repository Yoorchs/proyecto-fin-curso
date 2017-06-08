package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dbms.persistence.Curso;

public interface CursoIService {

	/**
	 * 
	 * @param codCurso
	 * @return
	 */
	public Curso getById(String codCurso);

	/**
	 * 
	 * @return
	 */
	public List<Curso> getAll();
	
	/**
	 * 
	 * @param curso
	 * @return
	 */
	public Curso update(Curso curso);
	
	/**
	 * 
	 * @param codCurso
	 */
	public void delete(String codCurso);
	
	/**
	 * 
	 * @param curso
	 * @return
	 */
	public Curso create(Curso curso);
}