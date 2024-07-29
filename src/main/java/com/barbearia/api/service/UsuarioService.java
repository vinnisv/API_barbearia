package com.barbearia.api.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.barbearia.api.model.UsuarioVO;
import com.barbearia.api.repository.UsuarioRepository;
import com.barbearia.api.util.Retorno;
import com.barbearia.api.util.RetornoBuilder;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	public Retorno buscarTodosUsuarios() {
		Retorno retorno = new Retorno();
		try {
			List<UsuarioVO> listaUsuarios = usuarioRepository.findAll();
			if(!listaUsuarios.isEmpty()) {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("Usuarios encontrados com sucesso!").comObjeto(listaUsuarios).construir();	
			} else {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("Usuarios não encontrados!").construir();	
			}
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno buscarPorCodUsuario(Long codUsuario) throws Exception {
		Retorno retorno = new Retorno();
		try {
			UsuarioVO usuario = usuarioRepository.findById(codUsuario).orElseThrow(()-> new Exception("Codigo do usuario invalido"));
			if(Objects.nonNull(usuario)) {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("Usuario encontrado com sucesso!").comObjeto(usuario).construir();	
			} else {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("Usuario não encontrado!").construir();	
			}
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	
	public Retorno gravarUsuario(UsuarioVO usuarioVO) {
		Retorno retorno = new Retorno();
		try {
			if(Objects.isNull(usuarioVO)){
				return new RetornoBuilder().comCodigoMensagem(HttpStatus.NOT_ACCEPTABLE.value()).comMensagem("Objeto invalido!").construir();	
			} else {
				UsuarioVO usuario = usuarioRepository.save(usuarioVO);
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.CREATED.value()).comMensagem("Usuario cadastrado com sucesso!").comObjeto(usuario).construir();
			} 
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	

	public Retorno editarUsuario(UsuarioVO usuarioVO) {
		Retorno retorno = new Retorno();
		try {
			if(Objects.isNull(usuarioVO.getCodUsuario())){
				return new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("Objeto não encontrado!").construir();	
			} else {
				UsuarioVO usuario = usuarioRepository.save(usuarioVO);
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("Usuario atualizado com sucesso!").comObjeto(usuario).construir();
			} 
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
		
	}
	
	public Retorno deletarUsuario(Long codUsuario) {
		Retorno retorno = new Retorno();
		try {
			UsuarioVO usuario = usuarioRepository.findById(codUsuario).orElseThrow(()-> new Exception("Codigo do usuario invalido"));
			usuarioRepository.delete(usuario);
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("Usuario excluido com sucesso!").construir();	
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
}
