package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Banco;
import model.Carrinho;
import model.Compra;

/**
 * Servlet implementation class servletFinalizarCompra
 */
@WebServlet("/servletFinalizarCompra.jsp")
public class servletFinalizarCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletFinalizarCompra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		String nomeCliente = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		
		System.out.println(nomeCliente + " - " + endereco);
		
		Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
		
		Compra compra = new Compra(nomeCliente, endereco, carrinho, carrinho.getTotal());
		
		Banco.getInstance().addCompra(compra);
		
		carrinho = new Carrinho();
		
		session.setAttribute("carrinho", carrinho);
		
		response.sendRedirect("listar_produtos.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
