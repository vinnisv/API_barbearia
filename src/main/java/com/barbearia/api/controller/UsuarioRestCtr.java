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

import com.barbearia.api.model.UsuarioVO;
import com.barbearia.api.service.UsuarioService;
import com.barbearia.api.util.Retorno;

@RestController 
@RequestMapping("/usuario") 
public class UsuarioRestCtr {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping()
	public Retorno buscarTodosUsuarios() {
		return usuarioService.buscarTodosUsuarios();
	}
	
	
	@GetMapping("/buscar-por-codigo/{codUsuario}")
	public Retorno buscarPorCodUsuario(@PathVariable Long codUsuario) throws Exception {
		return usuarioService.buscarPorCodUsuario(codUsuario);
	}
		
	@PostMapping()
	public Retorno gravarUsuario(@RequestBody UsuarioVO usuarioVO) {
		return usuarioService.gravarUsuario(usuarioVO);
	}
	
	@PutMapping()
	public Retorno editarUsuario(@RequestBody UsuarioVO usuarioVO) {
		return usuarioService.editarUsuario(usuarioVO);
	}
	
	@DeleteMapping("/{codUsuario}")
	public Retorno deletarUsuario(@PathVariable Long codUsuario) {
		return usuarioService.deletarUsuario(codUsuario);
	}


}
