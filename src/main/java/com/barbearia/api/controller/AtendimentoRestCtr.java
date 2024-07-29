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

import com.barbearia.api.dto.AtendimentoDTO;
import com.barbearia.api.model.AtendimentoVO;
import com.barbearia.api.service.AtendimentoService;
import com.barbearia.api.util.Retorno;

@RestController 
@RequestMapping("/atendimento") 

public class AtendimentoRestCtr {
	@Autowired
	private AtendimentoService atendimentoService;
	
	@GetMapping()
	public Retorno buscarTodosAtendimentos() {
		return atendimentoService.buscarTodosAtendimentos();
	}
	
	
	@GetMapping("/buscar-por-codigo/{codAtendimento}")
	public Retorno buscarPorCodAtendimento(@PathVariable Long codAtendimento) throws Exception {
		return atendimentoService.buscarPorCodAtendimento(codAtendimento);
	}
	
	@GetMapping("/buscar-por-codigo-usuario/{codUsuario}")
	public Retorno buscarPorCodUsuario(@PathVariable Long codUsuario) {
		return atendimentoService.buscarPorCodUsuario(codUsuario);
	}
	
	@GetMapping("/buscar-por-codigo-profissional/{codProfissional}")
	public Retorno buscarPorCodProfissional(@PathVariable Long codProfissional) {
		return atendimentoService.buscarPorCodProfissional(codProfissional);
	}
	
	@PostMapping()
	public Retorno gravarAtendimento(@RequestBody AtendimentoDTO atendimentoDTO) {
		return atendimentoService.gravarAtendimento(atendimentoDTO);
	}
	
	@PutMapping()
	public Retorno editarAtendimento(@RequestBody AtendimentoVO atendimentoVO) {
		return atendimentoService.editarAtendimento(atendimentoVO);
	}
	
	@DeleteMapping("/{codAtendimento}")
	public Retorno deletarAtendimento(@PathVariable Long codAtendimento) {
		return atendimentoService.deletarAtendimento(codAtendimento);
	}
}
