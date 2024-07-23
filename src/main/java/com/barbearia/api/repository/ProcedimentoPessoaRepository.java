package com.barbearia.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbearia.api.model.ProcedimentoPessoaVO;

public interface ProcedimentoPessoaRepository extends JpaRepository<ProcedimentoPessoaVO, Long> {

}