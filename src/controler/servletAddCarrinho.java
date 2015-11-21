package controler;

import model.*;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class servletCarrinho
 */
@WebServlet("/servletAddCarinho.jsp")
public class servletAddCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletAddCarrinho() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		Carrinho carrinho = new Carrinho();
		
		String id = request.getParameter("id");		
		int idInt = Integer.parseInt(id);
		
		if(session == null){
			session = request.getSession(false);
			Produto p = Banco.getInstance().buscarProduto(idInt);
			p.setQtd(1);
			carrinho.adicionarProduto(p);
		}else if (session != null){
			carrinho = (Carrinho) session.getAttribute("carrinho");	
			if(carrinho == null){
				carrinho = new Carrinho();
				session = request.getSession(true);
				Produto p = Banco.getInstance().buscarProduto(idInt);
				p.setQtd(1);
				carrinho.adicionarProduto(p);	
				session.setAttribute("carrinho", carrinho);
			}else {
				System.out.println("Com sessão");
				carrinho = (Carrinho) session.getAttribute("carrinho");	
				
				Produto produto = Banco.getInstance().buscarProduto(idInt);
				Produto produtoAux = new Produto();
				
				List<Produto> _listaProdutos = carrinho.getListaDeProdutos();
			
				if(carrinho.buscarProduto(produto.getCod())){
					for (Produto _p : _listaProdutos){
						if(_p.getCod() == produto.getCod()){
							produtoAux = _p;
							System.out.println("Quantidade "+ _p.getQtd());
						}
					}
				carrinho.removerProduto(produtoAux);
				produtoAux.setQtd(produtoAux.getQtd()+1);
				carrinho.adicionarProduto(produtoAux);
				}else{
					carrinho.adicionarProduto(produto);
				}		
		}
	}
		
	session = request.getSession(true);
	session.setAttribute("carrinho", carrinho);
	response.sendRedirect("listar_produtos.jsp");
		
	}
}	
