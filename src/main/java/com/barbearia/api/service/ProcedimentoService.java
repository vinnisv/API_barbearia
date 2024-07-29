package com.barbearia.api.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.barbearia.api.model.ProcedimentoVO;
import com.barbearia.api.repository.ProcedimentoRepository;
import com.barbearia.api.util.Retorno;
import com.barbearia.api.util.RetornoBuilder;

@Service
public class ProcedimentoService {
	@Autowired
	private ProcedimentoRepository procedimentoRepository;
	
	
	public Retorno buscarTodosProcedimentos() {
		Retorno retorno = new Retorno();
		try {
			List<ProcedimentoVO> listaProcedimentos = procedimentoRepository.findAll();
			if(!listaProcedimentos.isEmpty()) {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("Procedimentos encontrados com sucesso!").comObjeto(listaProcedimentos).construir();	
			} else {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("Procedimentos não encontrados!").construir();	
			}
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno buscarPorCodProcedimento(Long codProcedimento) throws Exception {
		Retorno retorno = new Retorno();
		try {
			ProcedimentoVO procedimento = procedimentoRepository.findById(codProcedimento).orElseThrow(()-> new Exception("Código do procedimento inválido!"));
			if(Objects.nonNull(procedimento)) {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("Procedimento encontrado com sucesso!").comObjeto(procedimento).construir();	
			} else {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("Procedimento não encontrado!").construir();	
			}
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}

	public Retorno gravarProcedimento(ProcedimentoVO procedimentoVO) {
		Retorno retorno = new Retorno();
		try {
			if(Objects.isNull(procedimentoVO)){
				return new RetornoBuilder().comCodigoMensagem(HttpStatus.NOT_ACCEPTABLE.value()).comMensagem("Objeto invalido!").construir();	
			} else {
				ProcedimentoVO procedimento = procedimentoRepository.save(procedimentoVO);
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.CREATED.value()).comMensagem("Procedimento cadastrado com sucesso!").comObjeto(procedimento).construir();
			} 
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	

	public Retorno editarProcedimento(ProcedimentoVO procedimentoVO) {
		Retorno retorno = new Retorno();
		try {
			if(Objects.isNull(procedimentoVO.getCodProcedimento())){
				return new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("Objeto não encontrado!").construir();	
			} else {
				ProcedimentoVO procedimento = procedimentoRepository.save(procedimentoVO);
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("Procedimento atualizado com sucesso!").comObjeto(procedimento).construir();
			} 
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno deletarProcedimento(Long codProcedimento) {
		Retorno retorno = new Retorno();
		try {
			ProcedimentoVO procedimento = procedimentoRepository.findById(codProcedimento).orElseThrow(()-> new Exception("Código do procedimento invalido"));
			procedimentoRepository.delete(procedimento);
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("Procedimento excluido com sucesso!").construir();	
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
}
