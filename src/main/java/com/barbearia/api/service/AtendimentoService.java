package com.barbearia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbearia.api.model.AtendimentoVO;
import com.barbearia.api.repository.AtendimentoRepository;

@Service

public class AtendimentoService {
	@Autowired
	private AtendimentoRepository atendimentoRepository;
	
	
	public List<AtendimentoVO> buscarTodosAtendimentos() {
		return atendimentoRepository.findAll();
	}
	
	public AtendimentoVO buscarPorCodAtendimento(Long codAtendimento) throws Exception {
		return atendimentoRepository.findById(codAtendimento).orElseThrow(()-> new Exception("Codigo atendimento invalido"));
	}
	
	
	public List<AtendimentoVO> buscarPorCodUsuario(Long codUsuario) {
		return atendimentoRepository.findByCodUsuario(codUsuario);
	}
	
	
	public List<AtendimentoVO> buscarPorCodProfissional(Long codProfissional) {
		return atendimentoRepository.findByCodProfissional(codProfissional);
	}
	

	public AtendimentoVO gravarAtendimento(AtendimentoVO atendimentoVO) {
		return atendimentoRepository.save(atendimentoVO);
	}
	

	public AtendimentoVO editarAtendimento(AtendimentoVO atendimentoVO) {
		return atendimentoRepository.save(atendimentoVO);
	}
	
	public void deletarAtendimento(Long codAtendimento) {
		atendimentoRepository.deleteById(codAtendimento);
	}
}
