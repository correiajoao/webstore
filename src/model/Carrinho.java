package model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	
	private List<Produto> lista = new ArrayList<Produto>(); 

	public List<Produto> getListaDeProdutos() {
		return lista;
	}

	public void adicionarProduto(Produto p){
		p.setQtd(1);
		lista.add(p);
	}
	
	public boolean buscarProduto(int cod){
		boolean result = false;
		for (Produto produto : lista) {
			if(produto.getCod() == cod){
				result = true;
			}
		}
		return result;
	}
	
	public void atualizarQuantidade(int cod){
		Produto p = new Produto();
		for (Produto produto : lista) {
			if(produto.getCod() == cod){
				p = produto;
			}
		}
		lista.remove(p);
		p.setQtd(p.getQtd()+1);
		lista.add(p);
	}
}
