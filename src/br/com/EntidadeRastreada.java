package br.com;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.UsuarioUtil;
import enity.Pessoa;

/**
 * Inclui mecanismos de gravação de data de criação, data de atualização, e
 * usuário de atualização de uma entidade.<br/>
 * Deve ser estendido pelas entidades que quiserem utilizar
 * esses atributos.
 *  
 * @author Renan
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class EntidadeRastreada implements ObjetoPersistivel {

	/** Data de criação do registro. */
	@Column(name="criado_em", nullable = false, updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	protected Date criadoEm;
	
	/** Usuário que criou o registro. */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_criado_por", referencedColumnName = "usuarioid", nullable=false, updatable=false)
	protected Pessoa criadoPor;
	
	/** Data da última atualização do registro. */
	@Column(name="atualizado_em")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date atualizadoEm;
	
	/** Usuário que atualizou o registro pela última vez. */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_atualizado_por", referencedColumnName = "usuarioid")
	protected Pessoa atualizadoPor;
	
	@PrePersist
	protected void onCreate(){
		criadoEm = new Date();
		criadoPor = UsuarioUtil.getPessoaLogado();
	}
	
	@PreUpdate
	protected void onUpdate(){
		atualizadoEm = new Date();
		atualizadoPor = UsuarioUtil.getPessoaLogado();
	}

	public Date getCriadoEm() {
		return criadoEm;
	}

	public Pessoa getCriadoPor() {
		return criadoPor;
	}

	public Date getAtualizadoEm() {
		return atualizadoEm;
	}

	public Pessoa getAtualizadoPor() {
		return atualizadoPor;
	}

	public void setCriadoEm(Date criadoEm) {
		this.criadoEm = criadoEm;
	}

	public void setCriadoPor(Pessoa criadoPor) {
		this.criadoPor = criadoPor;
	}

	public void setAtualizadoEm(Date atualizadoEm) {
		this.atualizadoEm = atualizadoEm;
	}

	public void setAtualizadoPor(Pessoa atualizadoPor) {
		this.atualizadoPor = atualizadoPor;
	}
	
}
