package com.barbearia.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbearia.api.model.ProcedimentoVO;

public interface ProcedimentoRepository extends JpaRepository<ProcedimentoVO, Long> {

}
