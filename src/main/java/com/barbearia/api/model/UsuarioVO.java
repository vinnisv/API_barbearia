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
@Table(name = "TB_USUARIO")
public class UsuarioVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long codUsuario;
	private String nomeUsuario;
	private String celUsuario;	
	
	@Id
	@SequenceGenerator(name="TB_USUARIO_SEQ", sequenceName="TB_USUARIO_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="TB_USUARIO_SEQ")
    @Column(name="COD_USUARIO")	
	public Long getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(Long codUsuario) {
		this.codUsuario = codUsuario;
	}
	
	@Column(name="NOME_USUARIO")
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	@Column(name="CEL_USUARIO")
	public String getCelUsuario() {
		return celUsuario;
	}
	public void setCelUsuario(String celUsuario) {
		this.celUsuario = celUsuario;
	}
	


}
