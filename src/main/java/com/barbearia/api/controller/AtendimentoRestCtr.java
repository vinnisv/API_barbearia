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

import com.barbearia.api.model.AtendimentoVO;
import com.barbearia.api.service.AtendimentoService;

@RestController 
@RequestMapping("/atendimento") 

public class AtendimentoRestCtr {
	@Autowired
	private AtendimentoService atendimentoService;
	
	@GetMapping()
	public List<AtendimentoVO> buscarTodosAtendimentos() {
		return atendimentoService.buscarTodosAtendimentos();
	}
	
	
	@GetMapping("/buscar-por-codigo/{codAtendimento}")
	public AtendimentoVO buscarPorCodAtendimento(@PathVariable Long codAtendimento) throws Exception {
		return atendimentoService.buscarPorCodAtendimento(codAtendimento);
	}
	
	@GetMapping("/buscar-por-codigo-usuario/{codUsuario}")
	public List<AtendimentoVO> buscarPorCodUsuario(@PathVariable Long codUsuario) {
		return atendimentoService.buscarPorCodUsuario(codUsuario);
	}
	
	@GetMapping("/buscar-por-codigo-profissional/{codProfissional}")
	public List<AtendimentoVO> buscarPorCodProfissional(@PathVariable Long codProfissional) {
		return atendimentoService.buscarPorCodProfissional(codProfissional);
	}
	
	@PostMapping()
	public AtendimentoVO gravarAtendimento(@RequestBody AtendimentoVO atendimentoVO) {
		return atendimentoService.gravarAtendimento(atendimentoVO);
	}
	
	@PutMapping()
	public AtendimentoVO editarAtendimento(@RequestBody AtendimentoVO atendimentoVO) {
		return atendimentoService.editarAtendimento(atendimentoVO);
	}
	
	@DeleteMapping("/{codAtendimento}")
	public void deletarAtendimento(@PathVariable Long codAtendimento) {
		atendimentoService.deletarAtendimento(codAtendimento);
	}
}
