package com.barbearia.api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ATENDIMENTO")
public class AtendimentoVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long codAtendimento;
	private Long codUsuario;
	private Date horarioInicio;
	private Date horarioFim;
	private Double valorAtendimento;
	private Long codProfissional;
	private UsuarioVO cliente;
	private ProfissionalVO profissional;
	private Set<ProcedimentoPessoaVO> procedimentos = new HashSet<>();
	
	@Id
	@SequenceGenerator(name="TB_ATENDIMENTO_SEQ", sequenceName="TB_ATENDIMENTO_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="TB_ATENDIMENTO_SEQ")
    @Column(name="COD_ATENDIMENTO") 
	public Long getCodAtendimento() {
		return codAtendimento;
	}

	public void setCodAtendimento(Long codAtendimento) {
		this.codAtendimento = codAtendimento;
	}
	
	@Column(name="COD_USUARIO")
	public Long getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(Long codUsuario) {
		this.codUsuario = codUsuario;
	}
	
	
	@Column(name="VALOR_ATENDIMENTO")
	public Double getValorAtendimento() {
		return valorAtendimento;
	}

	public void setValorAtendimento(Double valorAtendimento) {
		this.valorAtendimento = valorAtendimento;
	}

	@Column(name="COD_PROFISSIONAL")
	public Long getCodProfissional() {
		return codProfissional;
	}

	public void setCodProfissional(Long codProfissional) {
		this.codProfissional = codProfissional;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="COD_USUARIO", referencedColumnName = "COD_USUARIO", insertable = false, updatable=false) 
	public UsuarioVO getCliente() {
		return cliente;
	}

	public void setCliente(UsuarioVO cliente) {
		this.cliente = cliente;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="COD_PROFISSIONAL", referencedColumnName = "COD_PROFISSIONAL", insertable = false, updatable=false) 
	public ProfissionalVO getProfissional() {
		return profissional;
	}

	public void setProfissional(ProfissionalVO profissional) {
		this.profissional = profissional;
	}
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="COD_ATENDIMENTO", referencedColumnName = "COD_ATENDIMENTO", insertable = false, updatable=false) 
	public Set<ProcedimentoPessoaVO> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(Set<ProcedimentoPessoaVO> procedimentos) {
		this.procedimentos = procedimentos;
	}
	
	@Column(name="HORARIO_INICIO")
	public Date getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(Date horarioInicio) {
		this.horarioInicio = horarioInicio;
	}
	
	@Column(name="HORARIO_FIM")
	public Date getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(Date horarioFim) {
		this.horarioFim = horarioFim;
	}
	
	/* @Column(name="HORARIO_INICIO")
	public LocalTime getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(LocalTime horarioInicio) {
		this.horarioInicio = horarioInicio;
	}
	
	@Column(name="HORARIO_FIM")
	public LocalTime getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(LocalTime horarioFim) {
		this.horarioFim = horarioFim;
	}
	
	*/
	
	

}
