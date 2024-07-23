package com.barbearia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbearia.api.model.UsuarioVO;
import com.barbearia.api.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<UsuarioVO> buscarTodosUsuarios() {
		return usuarioRepository.findAll();
	}
	
	public UsuarioVO buscarPorCodUsuario(Long codUsuario) throws Exception {
		return usuarioRepository.findById(codUsuario).orElseThrow(()-> new Exception("Codigo do usuario invalido"));
	}
	
	
	public UsuarioVO gravarUsuario(UsuarioVO usuarioVO) {
		return usuarioRepository.save(usuarioVO);
	}
	

	public UsuarioVO editarUsuario(UsuarioVO usuarioVO) {
		return usuarioRepository.save(usuarioVO);
	}
	
	public void deletarUsuario(Long codUsuario) {
		usuarioRepository.deleteById(codUsuario);
	}
}
