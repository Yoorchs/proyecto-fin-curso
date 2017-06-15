package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dbms.persistence.Curso;

public interface CursoIService {

	/**
	 * Metodo para cargar el listado de cursos del CSV  a la BBDD
	 * @return
	 */
	public int cargarCSV(); 

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
	 * @param id
	 */
	public void delete(int id);
	
	/**
	 * 
	 * @param curso
	 * @return
	 */
	public Curso create(Curso curso);

	/**
	 * 
	 * @param codCurso
	 * @return Curso : el resuotado de la select en BBDD buscando por codigo de curso
	 */
	public List<Curso> getByCodigo(String codCurso);
}
