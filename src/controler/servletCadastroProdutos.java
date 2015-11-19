package controler;

import model.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class servletCadastro
 */
@WebServlet("/servletCadastroProdutos.jsp")
public class servletCadastroProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletCadastroProdutos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("cadastroFormulario.html").include(request,response);
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if(session != null){
			String nome = request.getParameter("nome");
			String descricao = request.getParameter("descricao");
			String preco = request.getParameter("preco");
			
			double precoDouble = Double.parseDouble(preco);
			
			Produto p = new Produto();
			p.setNome(nome);
			p.setDescricao(descricao);
			p.setPreco(precoDouble);
			
			Banco.getInstance().addProduto(p);
			response.sendRedirect("servletListarProdutos.jsp");
		}else{
			response.sendRedirect("loginAdministrador.html");
		}
	}

}
