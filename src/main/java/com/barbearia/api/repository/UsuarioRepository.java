package com.barbearia.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbearia.api.model.UsuarioVO;

public interface UsuarioRepository extends JpaRepository<UsuarioVO, Long> {

}
