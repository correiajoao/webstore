
import java.util.ArrayList;
import java.util.List;

public class Banco {
	private static Banco instance = null;

	private List<Produto> produtos;
	public static int cod = 0;

	private Banco() {
		produtos = new ArrayList<>();
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
	
	public Produto findProduto(int cod) {
		Produto result = new Produto();
		for (Produto p : produtos) {
			if(cod == p.getCod()){
				result = p;
			}
		}
		return result;
	}
}
