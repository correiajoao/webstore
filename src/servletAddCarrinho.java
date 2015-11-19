

import java.io.IOException;
import java.util.ArrayList;
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
			System.out.println("Sem sessão");
			session = request.getSession(true);
			Produto p = Banco.getInstance().findProduto(idInt);
			carrinho.adicionarProduto(p);
		}else{
			System.out.println("Com sessão");
			carrinho = (Carrinho) session.getAttribute("carrinho");	
			Produto p = Banco.getInstance().findProduto(idInt);
			List<Produto> listaProdutos = carrinho.getListaDeProdutos();
			
			if(carrinho.buscarProduto(p.getCod())){
				for (Produto _p : listaProdutos) {
					if(_p.getCod() == p.getCod()){
						carrinho.atualizarQuantidade(_p.getCod());
					}
				}
			}else{
				carrinho.adicionarProduto(p);
			}
		}
		
		session.setAttribute("carrinho", carrinho);
		response.sendRedirect("servletProdutosCarrinho.jsp");
	
		}

}
