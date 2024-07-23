package com.barbearia.api.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name = "TB_PROFISSIONAL")
public class ProfissionalVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long codProfissional;
	private String nomeProfissional;
	private String tipoProfissional;
	
	@Id
	@SequenceGenerator(name="TB_PROFISSIONAL_SEQ", sequenceName="TB_PROFISSIONAL_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="TB_PROFISSIONAL_SEQ")
    @Column(name="COD_PROFISSIONAL") 
	public Long getCodProfissional() {
		return codProfissional;
	}
	
	public void setCodProfissional(Long codProfissional) {
		this.codProfissional = codProfissional;
	}
	
	@Column(name="NOME_PROFISSIONAL") 
	public String getNomeProfissional() {
		return nomeProfissional;
	}
	public void setNomeProfissional(String nomeProfissional) {
		this.nomeProfissional = nomeProfissional;
	}
	
	@Column(name="TIPO_PROFISSIONAL") 
	public String getTipoProfissional() {
		return tipoProfissional;
	}
	public void setTipoProfissional(String tipoProfissional) {
		this.tipoProfissional = tipoProfissional;
	}
	
	
}
