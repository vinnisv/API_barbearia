package com.barbearia.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barbearia.api.model.ProcedimentoVO;
import com.barbearia.api.service.ProcedimentoService;

@RestController 
@RequestMapping("/procedimento") 

public class ProcedimentoRestCtr {
	@Autowired
	private ProcedimentoService procedimentoService;
	
	@GetMapping()
	public List<ProcedimentoVO> buscarTodosProcedimentos() {
		return procedimentoService.buscarTodosProcedimentos();
	}
	
	
	@GetMapping("/buscar-por-codigo/{codProcedimento}")
	public ProcedimentoVO buscarPorCodProcedimento(@PathVariable Long codProcedimento) throws Exception {
		return procedimentoService.buscarPorCodProcedimento(codProcedimento);
	}
		
	@PostMapping()
	public ProcedimentoVO gravarProcedimento(@RequestBody ProcedimentoVO procedimentoVO) {
		return procedimentoService.gravarProcedimento(procedimentoVO);
	}
	
	@PutMapping()
	public ProcedimentoVO editarProcedimento(@RequestBody ProcedimentoVO procedimentoVO) {
		return procedimentoService.editarProcedimento(procedimentoVO);
	}
	
	@DeleteMapping("/{codProcedimento}")
	public void deletarProcedimento(@PathVariable Long codProcedimento) {
		procedimentoService.deletarProcedimento(codProcedimento);
	}

}
