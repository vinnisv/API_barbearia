package com.barbearia.api.controller;

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
import com.barbearia.api.util.Retorno;

@RestController 
@RequestMapping("/procedimento") 

public class ProcedimentoRestCtr {
	@Autowired
	private ProcedimentoService procedimentoService;
	
	@GetMapping()
	public Retorno buscarTodosProcedimentos() {
		return procedimentoService.buscarTodosProcedimentos();
	}
	
	
	@GetMapping("/buscar-por-codigo/{codProcedimento}")
	public Retorno buscarPorCodProcedimento(@PathVariable Long codProcedimento) throws Exception {
		return procedimentoService.buscarPorCodProcedimento(codProcedimento);
	}
		
	@PostMapping()
	public Retorno gravarProcedimento(@RequestBody ProcedimentoVO procedimentoVO) {
		return procedimentoService.gravarProcedimento(procedimentoVO);
	}
	
	@PutMapping()
	public Retorno editarProcedimento(@RequestBody ProcedimentoVO procedimentoVO) {
		return procedimentoService.editarProcedimento(procedimentoVO);
	}
	
	@DeleteMapping("/{codProcedimento}")
	public Retorno deletarProcedimento(@PathVariable Long codProcedimento) {
		return procedimentoService.deletarProcedimento(codProcedimento);
	}

}
