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

import com.barbearia.api.model.UsuarioVO;
import com.barbearia.api.service.UsuarioService;

@RestController 
@RequestMapping("/usuario") 
public class UsuarioRestCtr {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping()
	public List<UsuarioVO> buscarTodosUsuarios() {
		return usuarioService.buscarTodosUsuarios();
	}
	
	
	@GetMapping("/buscar-por-codigo/{codUsuario}")
	public UsuarioVO buscarPorCodUsuario(@PathVariable Long codUsuario) throws Exception {
		return usuarioService.buscarPorCodUsuario(codUsuario);
	}
		
	@PostMapping()
	public UsuarioVO gravarUsuario(@RequestBody UsuarioVO usuarioVO) {
		return usuarioService.gravarUsuario(usuarioVO);
	}
	
	@PutMapping()
	public UsuarioVO editarUsuario(@RequestBody UsuarioVO usuarioVO) {
		return usuarioService.editarUsuario(usuarioVO);
	}
	
	@DeleteMapping("/{codUsuario}")
	public void deletarUsuario(@PathVariable Long codUsuario) {
		usuarioService.deletarUsuario(codUsuario);
	}


}
