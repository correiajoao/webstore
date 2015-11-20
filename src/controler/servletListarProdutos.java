package controler;

import model.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession(false);
		
		PrintWriter out = response.getWriter();
		List<Produto> produtos = Banco.getInstance().getProdutos();
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Lista</title>");
		out.println("<link href='css/bootstrap.css' rel='stylesheet' media='screen'>");
		out.println("<link href='css/webstore.css' rel='stylesheet' media='screen'>");
		out.println("</head>");
		out.println("<body>");
		if(session != null){
			Administrador admin = (Administrador) session.getAttribute("administrador");
			if(admin != null){				
				out.println("<nav class='navbar navbar-default'>");
				out.println("<div class='container-fluid'>");
				out.println("<div class='navbar-header'>");
				out.println("<a class='navbar-brand' href='index.html'>Home</a></div>");
				out.println("<div><ul class='nav navbar-nav'>");
				out.println("</ul></div></div></nav>");
				out.println("<div class='container'>");
				out.println("<div class='row'><p>");
				out.println("<div class='col-md-offset-2 col-md-8'>");
				out.println("<div class='panel panel-default'>");
				out.println("<table class='table table-striped table-hover'>");
				
				out.println("<Caption>Produtos</Caption>");	
				out.println("<tr><th>Código</th><th>Nome</td><th>Descrição</th><th>Preço</th></tr>");
				
				for (Produto p : produtos) {
					out.println("<tr><td>"+p.getCod()+"</td><td>"+p.getNome()+"</td><td>"+p.getDescricao()+"</td><td>"+p.getPreco()+"</td></tr>");
				}
				out.println("</table>");
				out.println("<div class='panel-body'>");
				out.println("<a href='servletCadastroProdutos.jsp' class='btn btn-success'>Cadastrar Produto</a>");
				out.println("<a href='servletLogoutAdministrador.jsp'>Deslogar e finalizar cadastros</a>");
				out.println("</div></div></div></div></p></div>");
				out.println("</body>");
				out.println("</html>");
			}else{
				out.println("<nav class='navbar navbar-default'>");
				out.println("<div class='container-fluid'>");
				out.println("<div class='navbar-header'>");
				out.println("<a class='navbar-brand' href='index.html'>Home</a></div>");
				out.println("<div><ul class='nav navbar-nav'>");
				out.println("<li><a href='servletProdutosCarrinho.jsp'> Mostrar Carrinho</a></li>");
				out.println("<li><a href='servletLimparCarrinho.jsp'> Limpar Carrinho</a></li>");
				out.println("</ul></div></div></nav>");
				out.println("<div class='container'>");
				out.println("<div class='row'><p>");
				out.println("<div class='col-md-offset-2 col-md-8'>");
				out.println("<div class='panel panel-default'>");
				out.println("<table class='table table-striped table-hover'>");
				
				out.println("<Caption>Produtos</Caption>");	
				out.println("<tr><th>Código</th><th>Nome</td><th>Descrição</th><th>Preço</th><th>Compra</th></tr>");
				
				for (Produto p : produtos) {
					out.println("<tr><td>"+p.getCod()+"</td><td>"+p.getNome()+"</td><td>"+p.getDescricao()+"</td><td>"+p.getPreco()+"</td><td><form action='servletAddCarinho.jsp'> <input type='hidden' name='id' value='"+p.getCod()+"'><input type='submit' value='Comprar' class='btn btn-xs btn-primary'></form></td></tr>");
				}
				out.println("</table>");
				out.println("</div>");
				out.println("<a href='servletCadastroProdutos.jsp' class='btn btn-success'>Cadastrar Produto</a>");
				out.println("</div></div></p></div>");
				out.println("</body>");
				out.println("</html>");
			}
		}else{
			out.println("<nav class='navbar navbar-default'>");
			out.println("<div class='container-fluid'>");
			out.println("<div class='navbar-header'>");
			out.println("<a class='navbar-brand' href='index.html'>Home</a></div>");
			out.println("<div><ul class='nav navbar-nav'>");
			out.println("<li><a href='servletProdutosCarrinho.jsp'> Mostrar Carrinho</a></li>");
			out.println("<li><a href='servletLimparCarrinho.jsp'> Limpar Carrinho</a></li>");
			out.println("</ul></div></div></nav>");
			out.println("<div class='container'>");
			out.println("<div class='row'><p>");
			out.println("<div class='col-md-offset-2 col-md-8'>");
			out.println("<div class='panel panel-default'>");
			out.println("<table class='table table-striped table-hover'>");
			
			out.println("<Caption>Produtos</Caption>");	
			out.println("<tr><th>Código</th><th>Nome</td><th>Descrição</th><th>Preço</th><th>Compra</th></tr>");
			
			for (Produto p : produtos) {
				out.println("<tr><td>"+p.getCod()+"</td><td>"+p.getNome()+"</td><td>"+p.getDescricao()+"</td><td>"+p.getPreco()+"</td><td><form action='servletAddCarinho.jsp'> <input type='hidden' name='id' value='"+p.getCod()+"'><input type='submit' value='Comprar' class='btn btn-xs btn-primary'></form></td></tr>");
			}
			out.println("</table>");
			out.println("</div>");
			out.println("<a href='servletCadastroProdutos.jsp' class='btn btn-success'>Cadastrar Produto</a>");
			out.println("</div></div></p></div>");
			out.println("</body>");
			out.println("</html>");
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
