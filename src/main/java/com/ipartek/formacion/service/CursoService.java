package com.ipartek.formacion.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipartek.formacion.dbms.dao.interfaces.CursoIDAO;
import com.ipartek.formacion.dbms.persistence.Curso;
import com.ipartek.formacion.service.interfaces.CursoIService;

@Service("cursoService")
public class CursoService implements CursoIService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(CursoService.class);
	
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

	@Override
	public List<Curso> getByCodigo(String codCurso) {
		return cursoIDao.getByCodigo(codCurso);
	}

	@Override
	public int cargarCSV() {
		String separador = ";";
		BufferedReader br = null;
	      try {
	         br =new BufferedReader(new FileReader("C:\\Desarrollo\\Git\\proyecto-fin-curso\\src\\main\\webapp\\resources\\csv\\cursos.csv"));
	         String line = br.readLine();
	         line = br.readLine();
	         Curso curso = new Curso();
	         while (null!=line) {
	            String [] fields = line.split(separador);
	            try {
					if(fields.length >8 && (null!=fields[1] || null!=fields[8])){
						curso.setNomCurso(fields[1]);
						curso.setCodCurso(fields[8]);
						cursoIDao.create(curso);
					}
					line = br.readLine();
				} catch (Exception e) {
					e.printStackTrace();
				}
	         }
	         
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      } finally {
	         if (null!=br) {
	            try {
					br.close();
				} catch (IOException e) {
					e.getMessage();
				}
	         }
	      }
		return 0;
	}
}
