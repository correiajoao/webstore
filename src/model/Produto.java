package model;

public class Produto {
	private int cod;
	private String nome;
	private String descricao;
	private double preco;
	private int qtd;
	
	public Produto(int cod, String nome, String descricao, double preco, int qtd) {
		this.cod = cod;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.qtd = qtd;
	}
	
	public Produto() {
	
	}
	
	/**
	 * @return the cod
	 */
	public int getCod() {
		return cod;
	}
	/**
	 * @param cod the cod to set
	 */
	public void setCod(int cod) {
		this.cod = cod;
	}
	
	public int getQtd() {
		return qtd;
	}
	
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	
}
