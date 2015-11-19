package controler;

import model.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

/**
 * Servlet implementation class servletListagem
 */
@WebServlet("/servletListarProdutos.jsp")
public class servletListarProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletListarProdutos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<Produto> produtos = Banco.getInstance().getProdutos();
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Lista</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border='1'>");
		
		out.println("<Caption> Listagem de produtos</Caption>");
		out.println("<tr><th>Código</th><th>Nome</td><th>Descrição</th><th>Preço</th><th>Compra</th></tr>");
		
		for (Produto p : produtos) {
			out.println("<tr><td>"+p.getCod()+"</td><td>"+p.getNome()+"</td><td>"+p.getDescricao()+"</td><td>"+p.getPreco()+"</td><td><form action='servletAddCarinho.jsp'> <input type='hidden' name='id' value='"+p.getCod()+"'><input type='submit' value='Comprar'></form></td></tr>");
		}
		
		out.println("</table>");
		out.println("<a href='servletProdutosCarrinho.jsp'> Mostrar Carrinho</a>");
		out.println("<a href='servletLimparCarrinho.jsp'> Limpar Carrinho</a>");
		out.println("<a href='index.html'> Página inicial</a>");
		out.println("<a href='servletCadastroProdutos.jsp'>Cadastrar Produto</a>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
