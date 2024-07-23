package com.barbearia.api.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name = "TB_PROCEDIMENTO_PESSOA")
public class ProcedimentoPessoaVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long codProcedimentoPessoa;
	private Long codAtendimento;
	private Long codProcedimento;
	
	private ProcedimentoVO procedimento;
	
	@Id
	@SequenceGenerator(name="TB_PROCEDIMENTO_PESSOA_SEQ", sequenceName="TB_PROCEDIMENTO_PESSOA_SEQ", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="TB_PROCEDIMENTO_PESSOA_SEQ")
	@Column(name="COD_PROCEDIMENTO_PESSOA")	
	public Long getCodProcedimentoPessoa() {
		return codProcedimentoPessoa;
	}
	public void setCodProcedimentoPessoa(Long codProcedimentoPessoa) {
		this.codProcedimentoPessoa = codProcedimentoPessoa;
	}
		
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="COD_PROCEDIMENTO", referencedColumnName = "COD_PROCEDIMENTO", insertable = false, updatable=false)
	public ProcedimentoVO getProcedimento() {
		return procedimento;
	}
	public void setProcedimento(ProcedimentoVO procedimento) {
		this.procedimento = procedimento;
	}
	
	@Column(name="COD_ATENDIMENTO")	
	public Long getCodAtendimento() {
		return codAtendimento;
	}
	public void setCodAtendimento(Long codAtendimento) {
		this.codAtendimento = codAtendimento;
	}
	
	@Column(name="COD_PROCEDIMENTO")	
	public Long getCodProcedimento() {
		return codProcedimento;
	}
	public void setCodProcedimento(Long codProcedimento) {
		this.codProcedimento = codProcedimento;
	}
	
	
	
}
