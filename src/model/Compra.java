package model;

public class Compra {
	private int cod;
	private String nomeCliente;
	private String endereco;
	private Carrinho carrinho;
	private double total;

	public Compra(String nomeCliente, String endereco, Carrinho carrinho, double total) {
		super();
		this.nomeCliente = nomeCliente;
		this.endereco = endereco;
		this.carrinho = carrinho;
		this.total = total;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}
}
