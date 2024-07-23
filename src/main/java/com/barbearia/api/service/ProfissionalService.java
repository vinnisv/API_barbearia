package com.barbearia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbearia.api.model.ProfissionalVO;
import com.barbearia.api.repository.ProfissionalRepository;

@Service
public class ProfissionalService {
	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	public List<ProfissionalVO> buscarTodosProfissionais() {
		return profissionalRepository.findAll();
	}
	
	public ProfissionalVO buscarPorCodProfissional(Long codProfissional) throws Exception {
		return profissionalRepository.findById(codProfissional).orElseThrow(()-> new Exception("Código do Profissional inválido"));
	}
	

	public ProfissionalVO gravarProfissional(ProfissionalVO profissionalVO) {
		return profissionalRepository.save(profissionalVO);
	}
	

	public ProfissionalVO editarProfissional(ProfissionalVO profissionalVO) {
		return profissionalRepository.save(profissionalVO);
	}
	
	public void deletarProfissional(Long codprofissional) {
		profissionalRepository.deleteById(codprofissional);
	}
}
