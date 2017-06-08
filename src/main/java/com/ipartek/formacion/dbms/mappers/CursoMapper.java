package com.ipartek.formacion.dbms.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dbms.persistence.Curso;

public class CursoMapper implements RowMapper<Curso>{
	
	@Override
	public Curso mapRow(ResultSet resultSet, int rowCount) throws SQLException {
		Curso curso = new Curso();
		curso.setCodigo(resultSet.getInt("codigo"));
		curso.setCodCurso(resultSet.getString("codCurso"));
		curso.setNomCurso(resultSet.getString("nomCurso"));
		return curso;
	}

}
