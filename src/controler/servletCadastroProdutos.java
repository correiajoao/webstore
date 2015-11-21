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
		HttpSession session = request.getSession(false);
	
		if(session != null){
			Administrador admin = (Administrador) session.getAttribute("administrador");
			
			if(admin != null){
				response.sendRedirect("cadastrar_produtos.jsp");
			}else{
				response.sendRedirect("login_administrador.jsp");
			}
		}else{
			response.sendRedirect("login_administrador.jsp");
		}
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if(session != null){
			Administrador admin = (Administrador) session.getAttribute("administrador");
			
			if(admin != null){			
				String nome = request.getParameter("nome");
				String descricao = request.getParameter("descricao");
				String preco = request.getParameter("preco");
				
				double precoDouble = Double.parseDouble(preco);
				
				Produto p = new Produto();
				p.setNome(nome);
				p.setDescricao(descricao);
				p.setPreco(precoDouble);
				
				Banco.getInstance().addProduto(p);
				response.sendRedirect("listar_produtos.jsp");
			}else{
				response.sendRedirect("login_administrador.html");
			}
		}else{
			response.sendRedirect("login_administrador.html");
		}	
	}

}
