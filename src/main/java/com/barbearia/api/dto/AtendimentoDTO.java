package com.barbearia.api.dto;

import java.util.HashSet;
import java.util.Set;

import com.barbearia.api.model.AtendimentoVO;
import com.barbearia.api.model.ProcedimentoVO;

public class AtendimentoDTO {
	private AtendimentoVO atendimentoVO;
	private Set<ProcedimentoVO> procedimentoVO = new HashSet<>();
	public AtendimentoVO getAtendimentoVO() {
		return atendimentoVO;
	}
	public void setAtendimentoVO(AtendimentoVO atendimentoVO) {
		this.atendimentoVO = atendimentoVO;
	}
	public Set<ProcedimentoVO> getProcedimentoVO() {
		return procedimentoVO;
	}
	public void setProcedimentoVO(Set<ProcedimentoVO> procedimentoVO) {
		this.procedimentoVO = procedimentoVO;
	}
	

}
