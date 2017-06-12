package com.ipartek.formacion.dbms.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dbms.persistence.Curso;

/**
 * Esta intefaz define los metodos de consulta a Base de Datos de la entidad
 * Curso que tiene su correspondencia en la clase <code>Curso</code> de la
 * capa de persistencia.
 * 
 * @author jmanso.
 *
 */
public interface CursoIDAO extends DAOSetter{
	
	/**
	 * Metodo para crear un nuevo curso e insertarlo en la BBDD
	 * @param curso
	 * @return Curso : El curso a insertar
	 */
	public Curso create(Curso curso);

	/**
	 * Metodo para obtener el listado completo de <code>Curso</code> de la BBDD 
	 * @return List<Curso> La lista de cursos completa
	 */
	public List<Curso> getAll();

	/**
	 * Metodo que obtiene un objeto <code>Curso</code> definido por so codigo de curso
	 * @param codCurso
	 * @return Curso: El <code>Curso</code> definido por so codigo de curso
	 */
	public Curso getById(String codCurso);

	/**
	 * Metodo que actualiza un <code>Curso</code> 
	 * @param curso
	 * @return Curso: El <code>Curso</code> actualizado
	 */
	public Curso update(Curso curso);

	/**
	 * Metodo que borra de la BBDD un <code>Curso</code> identificado por el codigo de Curso
	 * @param codCurso
	 */
	public void delete(int codCurso);

	/**
	 * Metodo que obtiene de la BBDD un <code>Curso</code> identificado por el codigo (Valor alfanumérico) de Curso
	 * @param codCurso
	 */
	public Curso getByCodigo(String codCurso);
}
