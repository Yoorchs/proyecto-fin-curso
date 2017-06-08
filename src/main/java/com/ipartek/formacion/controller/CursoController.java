package com.ipartek.formacion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.dbms.persistence.Curso;
import com.ipartek.formacion.service.interfaces.CursoIService;

@Controller
@RequestMapping("/cursos")
public class CursoController {
	
	@Autowired
	private CursoIService cS;
	private ModelAndView mav = null;
	private static final Logger LOGGER = LoggerFactory.getLogger(CursoController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		mav = new ModelAndView("cursos");
		mav.addObject("listadoCursos", cS.getAll());
		return mav;
	}
	
	@RequestMapping(value = "/{codCurso}")
	public ModelAndView getById(@PathVariable("codCurso") String codCurso){
		mav = new ModelAndView("curso");
		mav.addObject("curso", cS.getById(codCurso));
		return mav;
	}
	
	@RequestMapping(value = "/deleteCurso/{codCurso}")
	public String delete(@PathVariable("id") String id) {
		cS.delete(id);
		return "redirect:/cursos";
	}
	
	@RequestMapping(value = "/addCurso")
	public String addAlumno(Model model) {
		model.addAttribute("curso", new Curso());
		LOGGER.info(new Curso().toString());
		return "cursoform";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCurso(Model model, @ModelAttribute("curso") Curso curso) {
		String destino = "redirect:/cursos";
		if (curso.getCodigo() > Curso.CODIGO_NULO) {
				LOGGER.info(curso.toString());
				cS.update(curso);
			} else {
				LOGGER.info(curso.toString());
				cS.create(curso);
			}
		return destino;
	}
}
