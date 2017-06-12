package com.ipartek.formacion.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
@Resource(name = "cursoValidator")
private Validator validator = null;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
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
	public String delete(@PathVariable("codCurso") int id) {
		cS.delete(id);
		return "redirect:/cursos";
	}
	
	@RequestMapping(value = "/addCurso")
	public String addAlumno(Model model) {
		Curso curso = new Curso(); 
		model.addAttribute("curso",curso);
		cS.create(curso);
		return "curso";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCurso(Model model, @ModelAttribute("curso") @Validated Curso curso, BindingResult bindingresult) {
		String destino = "";
		if (bindingresult.hasErrors()) {
			LOGGER.info("Errores al crear el curso");
			destino = "curso";
		}else {
			destino = "redirect:/cursos";
			if (curso.getCodigo() > Curso.CODIGO_NULO) {
				LOGGER.info(curso.toString());
				cS.update(curso);
			} else {
				LOGGER.info(curso.toString());
				cS.create(curso);
			}
		}
		return destino;
	}
}