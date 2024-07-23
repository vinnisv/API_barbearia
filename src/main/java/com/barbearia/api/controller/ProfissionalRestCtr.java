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

import com.barbearia.api.model.ProfissionalVO;
import com.barbearia.api.service.ProfissionalService;

@RestController 
@RequestMapping("/profissional") 
public class ProfissionalRestCtr {
	@Autowired
	private ProfissionalService profissionalService;
	
	@GetMapping()
	public List<ProfissionalVO> buscarTodosProfissionais() {
		return profissionalService.buscarTodosProfissionais();
	}
	
	
	@GetMapping("/buscar-por-codigo/{codProfissional}")
	public ProfissionalVO buscarPorCodProfissional(@PathVariable Long codProfissional) throws Exception {
		return profissionalService.buscarPorCodProfissional(codProfissional);
	}
		
	@PostMapping()
	public ProfissionalVO gravarProfissional(@RequestBody ProfissionalVO profissionalVO) {
		return profissionalService.gravarProfissional(profissionalVO);
	}
	
	@PutMapping()
	public ProfissionalVO editarProfissional(@RequestBody ProfissionalVO profissionalVO) {
		return profissionalService.editarProfissional(profissionalVO);
	}
	
	@DeleteMapping("/{codProfissional}")
	public void deletarProfissional(@PathVariable Long codProfissional) {
		profissionalService.deletarProfissional(codProfissional);
	}

	
}
