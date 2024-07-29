package com.barbearia.api.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.barbearia.api.dto.AtendimentoDTO;
import com.barbearia.api.model.AtendimentoVO;
import com.barbearia.api.model.ProcedimentoPessoaVO;
import com.barbearia.api.model.ProcedimentoVO;
import com.barbearia.api.repository.AtendimentoRepository;
import com.barbearia.api.repository.ProcedimentoPessoaRepository;
import com.barbearia.api.repository.ProcedimentoRepository;
import com.barbearia.api.util.Retorno;
import com.barbearia.api.util.RetornoBuilder;

@Service

public class AtendimentoService {
	@Autowired
	private AtendimentoRepository atendimentoRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ProfissionalService profissionalService;
	
	@Autowired
	private ProcedimentoService procedimentoService;
	
	@Autowired
	private ProcedimentoPessoaRepository procedimentoPessoaRepository;
	@Autowired
	private ProcedimentoRepository procedimentoRepository;
	
	
	public Retorno buscarTodosAtendimentos() {
		Retorno retorno = new Retorno();
		try {
			List<AtendimentoVO> listaAtendimentos = atendimentoRepository.findAll();
			if(!listaAtendimentos.isEmpty()) {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("Atendimentos encontrados com sucesso!").comObjeto(listaAtendimentos).construir();	
			} else {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("Atendimentos não encontrados!").construir();	
			}
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno buscarPorCodAtendimento(Long codAtendimento) throws Exception {
		Retorno retorno = new Retorno();
		try {
			Optional<AtendimentoVO> atendimento = atendimentoRepository.findById(codAtendimento);
			if(atendimento.isPresent()) {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("Atendimento encontrado com sucesso!").comObjeto(atendimento).construir();	
			} else {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("Atendimento não encontrado!").construir();	
			}
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	
	public Retorno buscarPorCodUsuario(Long codUsuario) {
		Retorno retorno = new Retorno();
		try {
			List<AtendimentoVO> listaAtendimentos = atendimentoRepository.findByCodUsuario(codUsuario);
			if(!listaAtendimentos.isEmpty()) {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("Atendimentos encontrados com sucesso!").comObjeto(listaAtendimentos).construir();	
			} else {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("Atendimentos não encontrados!").construir();	
			}
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	
	public Retorno buscarPorCodProfissional(Long codProfissional) {
		Retorno retorno = new Retorno();
		try {
			List<AtendimentoVO> listaAtendimentos = atendimentoRepository.findByCodProfissional(codProfissional);
			if(!listaAtendimentos.isEmpty()) {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("Atendimentos encontrados com sucesso!").comObjeto(listaAtendimentos).construir();	
			} else {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("Atendimentos não encontrados!").construir();	
			}
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	

	public Retorno gravarAtendimento(AtendimentoDTO atendimentoDTO) {
		Retorno retorno = new Retorno();
		try {
			validarUsuarioEProfissional(atendimentoDTO.getAtendimentoVO());
			atendimentoDTO.getAtendimentoVO().setValorAtendimento(processaValorTotalEProcedimentos(atendimentoDTO));
			AtendimentoVO atendimento = atendimentoRepository.save(atendimentoDTO.getAtendimentoVO());
			
			if(Objects.nonNull(atendimento)){
				atendimento.setProcedimentos(new HashSet<>(gravarProcedimentoPessoa(atendimentoDTO, atendimento)));
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.CREATED.value()).comMensagem("Atendimento cadastrado com sucesso!").comObjeto(atendimento).construir();
				} 
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}

	private List<ProcedimentoPessoaVO> gravarProcedimentoPessoa(AtendimentoDTO atendimentoDTO, AtendimentoVO atendimento) {
		List<ProcedimentoPessoaVO> listaProcPessoa = new ArrayList<>();
		for(ProcedimentoVO proc:atendimentoDTO.getProcedimentoVO()) {
			ProcedimentoPessoaVO p = new ProcedimentoPessoaVO();
			p.setCodAtendimento(atendimento.getCodAtendimento());
			p.setCodProcedimento(proc.getCodProcedimento());
			listaProcPessoa.add(p);
			
		}
		return procedimentoPessoaRepository.saveAll(listaProcPessoa);
	}

	 private Double processaValorTotalEProcedimentos(AtendimentoDTO atendimentoDTO) throws Exception {
		Double valorTotal = 0.0;
		 for(ProcedimentoVO proc:atendimentoDTO.getProcedimentoVO()) {
			ProcedimentoVO procedimento = procedimentoRepository.findById(proc.getCodProcedimento()).orElseThrow(()-> new Exception("Procedimento não encontrado!"));
			valorTotal += procedimento.getValorProcedimento();
			
		}
		 return valorTotal; 
	} 
	 
	private void validarUsuarioEProfissional(AtendimentoVO atendimentoVO) throws Exception {
		if(atendimentoVO.getCodUsuario() !=null){
			usuarioService.buscarPorCodUsuario(atendimentoVO.getCodUsuario());
		}
		
		if(atendimentoVO.getCodProfissional() !=null){
			profissionalService.buscarPorCodProfissional(atendimentoVO.getCodProfissional());
		}
	}
	

	public Retorno editarAtendimento(AtendimentoVO atendimentoVO) {
		Retorno retorno = new Retorno();
		try {
			if(Objects.isNull(atendimentoVO.getCodAtendimento())){
				return new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("Objeto não encontrado!").construir();	
			} else {
				AtendimentoVO atendimento = atendimentoRepository.save(atendimentoVO);
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("Atendimento atualizado com sucesso!").comObjeto(atendimento).construir();
			} 
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno deletarAtendimento(Long codAtendimento) {
		Retorno retorno = new Retorno();
		try {
			List<ProcedimentoPessoaVO> listaProcedimentos = procedimentoPessoaRepository.findByCodAtendimento(codAtendimento);
			if(!listaProcedimentos.isEmpty()) {
				procedimentoPessoaRepository.deleteAll(listaProcedimentos);
			}
			AtendimentoVO atendimento = atendimentoRepository.findById(codAtendimento).orElseThrow(()-> new Exception("Código do atendimento invalido"));
			atendimentoRepository.delete(atendimento);
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("Atendimento excluido com sucesso!").construir();	
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
}
