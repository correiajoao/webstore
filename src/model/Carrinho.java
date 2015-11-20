package model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	
	private List<Produto> lista = new ArrayList<Produto>(); 

	public List<Produto> getListaDeProdutos() {
		return lista;
	}

	public void adicionarProduto(Produto p){
		lista.add(p);
	}
	
	public void removerProduto(Produto p){
		lista.remove(p);
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
}
