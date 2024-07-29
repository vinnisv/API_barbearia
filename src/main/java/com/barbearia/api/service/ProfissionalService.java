package com.barbearia.api.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.barbearia.api.model.ProfissionalVO;
import com.barbearia.api.repository.ProfissionalRepository;
import com.barbearia.api.util.Retorno;
import com.barbearia.api.util.RetornoBuilder;

@Service
public class ProfissionalService {
	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	public Retorno buscarTodosProfissionais() {
		Retorno retorno = new Retorno();
		try {
			List<ProfissionalVO> listaProfissionais = profissionalRepository.findAll();
			if(!listaProfissionais.isEmpty()) {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("Profissionais encontrados com sucesso!").comObjeto(listaProfissionais).construir();	
			} else {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("Profissionais não encontrados!").construir();	
			}
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno buscarPorCodProfissional(Long codProfissional) throws Exception {
		Retorno retorno = new Retorno();
		try {
			ProfissionalVO profissional = profissionalRepository.findById(codProfissional).orElseThrow(()-> new Exception("Código do Profissional inválido"));
			if(Objects.nonNull(profissional)) {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("Profissional encontrado com sucesso!").comObjeto(profissional).construir();	
			} else {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("Profissional não encontrado!").construir();	
			}
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	

	public Retorno gravarProfissional(ProfissionalVO profissionalVO) {
		Retorno retorno = new Retorno();
		try {
			if(Objects.isNull(profissionalVO)){
				return new RetornoBuilder().comCodigoMensagem(HttpStatus.NOT_ACCEPTABLE.value()).comMensagem("Objeto invalido!").construir();	
			} else {
				ProfissionalVO profissional = profissionalRepository.save(profissionalVO);
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.CREATED.value()).comMensagem("Profissional cadastrado com sucesso!").comObjeto(profissional).construir();
			} 
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	

	public Retorno editarProfissional(ProfissionalVO profissionalVO) {
		Retorno retorno = new Retorno();
		try {
			if(Objects.isNull(profissionalVO.getCodProfissional())){
				return new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("Objeto não encontrado!").construir();	
			} else {
				ProfissionalVO profissional = profissionalRepository.save(profissionalVO);
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("Profissional atualizado com sucesso!").comObjeto(profissional).construir();
			} 
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno deletarProfissional(Long codProfissional) {
		Retorno retorno = new Retorno();
		try {
			ProfissionalVO profissional = profissionalRepository.findById(codProfissional).orElseThrow(()-> new Exception("Codigo do profissional inválido"));
			profissionalRepository.delete(profissional);
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("Profissional excluido com sucesso!").construir();	
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
}
