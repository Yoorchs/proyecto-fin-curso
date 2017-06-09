package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipartek.formacion.dbms.dao.interfaces.CursoIDAO;
import com.ipartek.formacion.dbms.persistence.Curso;
import com.ipartek.formacion.service.interfaces.CursoIService;

@Service("cursoService")
public class CursoService implements CursoIService {

	@Autowired
	private CursoIDAO cursoIDao;
	
	@Override
	public Curso getById(String codCurso) {
		return cursoIDao.getById(codCurso);
	}

	@Override
	public List<Curso> getAll() {
		return cursoIDao.getAll();
	}

	@Transactional
	@Override
	public Curso update(Curso curso) {
		return cursoIDao.update(curso);
	}

	@Transactional
	@Override
	public void delete(int codCurso) {
		cursoIDao.delete(codCurso);

	}
	
	@Transactional
	@Override
	public Curso create(Curso curso) {
		return cursoIDao.create(curso);
	}

}
