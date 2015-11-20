package model;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	private static Banco instance = null;
	private List<Produto> produtos;
	Administrador admin;
	public static int cod = 3;

	
	private Banco() {
		produtos = new ArrayList<>();
		
		//Pré cadastro do administrador do sistema
		admin = new Administrador("admin@admin.com", "adminadmin");

		
		//Pré cadastro de produtos no sistema
		Produto p1 = new Produto(0,"Televisão 70''","Samsung - 4k",150000.00,1);
		produtos.add(p1);
		Produto p2 = new Produto(1,"Cama casal","Castor",1500.00,1);
		produtos.add(p2);
		Produto p3 = new Produto(2,"Ferro de passar","Bom",25.00,1);
		produtos.add(p3);
	}

	public static Banco getInstance() {
		if (instance == null)
			instance = new Banco();
		return instance;
	}

	public void addProduto(Produto p) {
		p.setCod(cod);
		produtos.add(p);
		cod++;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public Produto buscarProduto(int cod) {
		Produto result = new Produto();
		synchronized(produtos){
			for (Produto p : produtos) {
				if(cod == p.getCod()){
					result = p;
				}
			}
		}
		return result;
	}
	
	public boolean verificarAdmin(Administrador _admin){
		if(_admin.getEmail().equals(admin.getEmail()) && _admin.getSenha().equals(admin.getSenha())){
			return true;
		}else{
			return false;
		}
	}
}
