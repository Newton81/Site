package br.com;

public class Safras {

	private int id;
	private int ano;
	private String nome;
	private float producao;
	private float produtividade;
	private float valorSaca;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getProducao() {
		return producao;
	}
	public void setProducao(float producao) {
		this.producao = producao;
	}
	public float getProdutividade() {
		return produtividade;
	}
	public void setProdutividade(float produtividade) {
		this.produtividade = produtividade;
	}
	public float getValorSaca() {
		return valorSaca;
	}
	public void setValorSaca(float valorSaca) {
		this.valorSaca = valorSaca;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
}
