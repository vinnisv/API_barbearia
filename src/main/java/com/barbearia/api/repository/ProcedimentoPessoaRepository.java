package com.barbearia.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbearia.api.model.ProcedimentoPessoaVO;
import java.util.List;


public interface ProcedimentoPessoaRepository extends JpaRepository<ProcedimentoPessoaVO, Long> {
	List<ProcedimentoPessoaVO> findByCodAtendimento(Long codAtendimento);
}
