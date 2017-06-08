package com.ipartek.formacion.dbms.persistence;

import java.io.Serializable;

public class Curso implements Serializable, Comparable<Curso>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int CODIGO_NULO = -1;
	private Integer codigo;
	private String nomCurso;
	private String codCurso;
	
	/**
	 * Constructor de la clase Curso
	 */
	public Curso() {
		super();
		this.codigo = CODIGO_NULO;
		this.nomCurso = "";
		this.codCurso = "";
	}
	
	/**
	 * Getter de codigo
	 * @return codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}
	
	/**
	 * Setter de codigo
	 * @param codigo
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Getter de nomCurso
	 * @return nomcurso
	 */
	public String getNomCurso() {
		return nomCurso;
	}
	
	/**
	 * Setter de nomCurso
	 * @param nomcurso
	 */
	public void setNomCurso(String nomcurso) {
		this.nomCurso = nomcurso;
	}
	
	/**
	 * Getter de codCurso
	 * @return codCurso
	 */
	public String getCodCurso() {
		return codCurso;
	}
	
	/**
	 * Setter de codCurso
	 * @param codCurso
	 */
	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}
	
	/**
	 * @return result int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codCurso == null) ? 0 : codCurso.hashCode());
		return result;
	}
	
	/**
	 * Metodo que implementa equals
	 * @return boolean: Devuelve true si son iguales, false en caso contrario
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (codCurso == null) {
			if (other.codCurso != null)
				return false;
		} else if (!codCurso.equals(other.codCurso))
			return false;
		return true;
	}
	
	/**
	 * Metodo que implementa compareTo
	 * return int: El resultado de la comparacion
	 */
	@Override
	public int compareTo(Curso o) {
		return this.codCurso.compareToIgnoreCase(o.getCodCurso());
	}

	/**
	 * @return String 
	 */
	@Override
	public String toString() {
		return "Curso [codigo=" + codigo + ", nomcurso=" + nomCurso + ", codCurso=" + codCurso + "]";
	}
}
