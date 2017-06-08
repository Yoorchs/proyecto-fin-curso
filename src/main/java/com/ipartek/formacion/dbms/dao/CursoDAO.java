package com.ipartek.formacion.dbms.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dbms.dao.interfaces.CursoIDAO;
import com.ipartek.formacion.dbms.mappers.CursoMapper;
import com.ipartek.formacion.dbms.persistence.Curso;

@Repository("cursoDAO")
public class CursoDAO implements CursoIDAO {

	@Autowired
	@Qualifier("mysqlDataSource")
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;
	private final static Logger LOGGER = LoggerFactory.getLogger(CursoDAO.class);
	
	@Autowired
	@Qualifier("mysqlDataSource")
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Curso create(Curso curso) {
		final String SQL = "cursoCreate";
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		jdbcCall.withProcedureName(SQL);
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("pcodCurso", curso.getCodCurso())
				.addValue("pnomCurso", curso.getNomCurso());
		Map<String, Object> out = jdbcCall.execute(in);
		LOGGER.info(curso.toString());
		curso.setCodigo((Integer) out.get("pcodigo"));
		return curso;
	}

	@Override
	public List<Curso> getAll() {
		final String SQL = "CALL alumnogetAll();";
		List<Curso> cursos = null;
		try {
			cursos = jdbctemplate.query(SQL, new CursoMapper());
			LOGGER.info(String.valueOf(cursos.size()));
		} catch (EmptyResultDataAccessException e) {
			cursos = null;
			LOGGER.info("sin datos:" + e.getMessage() + " " + SQL);
		}
		return cursos;
	}

	@Override
	public Curso getById(String codCurso) {
		Curso curso = null;
		final String SQL = "CALL cursoGetById(?);";
		try {
			curso = jdbctemplate.queryForObject(SQL, new CursoMapper(), new Object[] { codCurso });
			LOGGER.info(curso.toString());
		} catch (EmptyResultDataAccessException e) {
			curso = null;
			LOGGER.info("No se ha encontrado el Curso con codigo: " + codCurso  + " " + e.getMessage());
		}
		return curso;
	}

	@Override
	public Curso update(Curso curso) {
		final String SQL = "cursoUpdate";
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		jdbcCall.withProcedureName(SQL);
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("pcodCurso", curso.getCodCurso())
				.addValue("pnomCurso", curso.getNomCurso())
				.addValue("pcodigo", curso.getCodigo());
		LOGGER.info(curso.toString());
		jdbcCall.execute(in);
		return curso;
	}

	@Override
	public void delete(String codCurso) {
		String SQL = "cursoDelete";
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		jdbcCall.withProcedureName(SQL);
		SqlParameterSource in = new MapSqlParameterSource().addValue("pcodCurso", codCurso);
		LOGGER.info("Borrando el curso con codigo " + codCurso);
		jdbcCall.execute(in);
	}
}
