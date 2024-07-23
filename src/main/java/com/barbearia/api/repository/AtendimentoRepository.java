package com.barbearia.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbearia.api.model.AtendimentoVO;
import java.util.List;


public interface AtendimentoRepository extends JpaRepository<AtendimentoVO, Long> {
	List<AtendimentoVO> findByCodUsuario(Long codUsuario);
	List<AtendimentoVO> findByCodProfissional(Long codProfissional);
	
}
