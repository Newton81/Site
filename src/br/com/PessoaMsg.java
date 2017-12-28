package br.com;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
 
@Entity
public class PessoaMsg {
	@Id
	@GeneratedValue
	private Long usuarioid;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String endereco;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String msg;

	public Long getUsuarioid() {
	return usuarioid;
	}
	public void setUsuarioid(Long usuarioid) {
	this.usuarioid = usuarioid;
	}
	public String getNome() {
	return nome;
	}
	public void setNome(String nome) {
	this.nome = nome;
	}
	public void setEmail(String email) {
	this.email = email;
	}
	public String getEmail() {
	return email;
	}
	public String getEndereco() {
	return endereco;
	}
	public void setEndereco(String endereco) {
	this.endereco = endereco;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	

	
	
}
