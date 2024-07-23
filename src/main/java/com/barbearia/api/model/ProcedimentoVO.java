package com.barbearia.api.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name = "TB_PROCEDIMENTO")
public class ProcedimentoVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long codProcedimento;
	private String nomeProcedimento;
	private Double valorProcedimento;
	private Long tempoProcedimento;
	
	@Id
	@SequenceGenerator(name="TB_PROCEDIMENTO_SEQ", sequenceName="TB_PROCEDIMENTO_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="TB_PROCEDIMENTO_SEQ")
    @Column(name="COD_PROCEDIMENTO") 
	public Long getCodProcedimento() {
		return codProcedimento;
	}
	public void setCodProcedimento(Long codProcedimento) {
		this.codProcedimento = codProcedimento;
	}
	
	 @Column(name="NOME_PROCEDIMENTO")
	public String getNomeProcedimento() {
		return nomeProcedimento;
	}
	public void setNomeProcedimento(String nomeProcedimento) {
		this.nomeProcedimento = nomeProcedimento;
	}
	
	 @Column(name="VALOR_PROCEDIMENTO")
	public Double getValorProcedimento() {
		return valorProcedimento;
	}
	public void setValorProcedimento(Double valorProcedimento) {
		this.valorProcedimento = valorProcedimento;
	}
	
	 @Column(name="TEMPO_PROCEDIMENTO")
	public Long getTempoProcedimento() {
		return tempoProcedimento;
	}
	public void setTempoProcedimento(Long tempoProcedimento) {
		this.tempoProcedimento = tempoProcedimento;
	}
	
	

}
