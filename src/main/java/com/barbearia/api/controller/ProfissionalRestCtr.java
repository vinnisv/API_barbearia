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

import com.barbearia.api.model.ProfissionalVO;
import com.barbearia.api.service.ProfissionalService;
import com.barbearia.api.util.Retorno;

@RestController 
@RequestMapping("/profissional") 
public class ProfissionalRestCtr {
	@Autowired
	private ProfissionalService profissionalService;
	
	@GetMapping()
	public Retorno buscarTodosProfissionais() {
		return profissionalService.buscarTodosProfissionais();
	}
	
	
	@GetMapping("/buscar-por-codigo/{codProfissional}")
	public Retorno buscarPorCodProfissional(@PathVariable Long codProfissional) throws Exception {
		return profissionalService.buscarPorCodProfissional(codProfissional);
	}
		
	@PostMapping()
	public Retorno gravarProfissional(@RequestBody ProfissionalVO profissionalVO) {
		return profissionalService.gravarProfissional(profissionalVO);
	}
	
	@PutMapping()
	public Retorno editarProfissional(@RequestBody ProfissionalVO profissionalVO) {
		return profissionalService.editarProfissional(profissionalVO);
	}
	
	@DeleteMapping("/{codProfissional}")
	public Retorno deletarProfissional(@PathVariable Long codProfissional) {
		return profissionalService.deletarProfissional(codProfissional);
	}

	
}
