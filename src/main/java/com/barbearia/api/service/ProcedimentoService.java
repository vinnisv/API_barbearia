package com.barbearia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbearia.api.model.ProcedimentoVO;
import com.barbearia.api.repository.ProcedimentoRepository;

@Service
public class ProcedimentoService {
	@Autowired
	private ProcedimentoRepository procedimentoRepository;
	
	public List<ProcedimentoVO> buscarTodosProcedimentos() {
		return procedimentoRepository.findAll();
	}
	
	public ProcedimentoVO buscarPorCodProcedimento(Long codProcedimento) throws Exception {
		return procedimentoRepository.findById(codProcedimento).orElseThrow(()-> new Exception("Código do procedimento inválido!"));
	}

	public ProcedimentoVO gravarProcedimento(ProcedimentoVO procedimentoVO) {
		return procedimentoRepository.save(procedimentoVO);
	}
	

	public ProcedimentoVO editarProcedimento(ProcedimentoVO procedimentoVO) {
		return procedimentoRepository.save(procedimentoVO);
	}
	
	public void deletarProcedimento(Long codProcedimento) {
		procedimentoRepository.deleteById(codProcedimento);
	}
}
