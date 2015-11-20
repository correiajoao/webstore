package controler;

import model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class servletListarProdutosCarrinho
 */
@WebServlet("/servletProdutosCarrinho.jsp")
public class servletProdutosCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletProdutosCarrinho() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Produtos no carrinho</title>");
		out.println("<link href='css/bootstrap.css' rel='stylesheet' media='screen'>");
		out.println("<link href='css/webstore.css' rel='stylesheet' media='screen'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<nav class='navbar navbar-default'>");
		out.println("<div class='container-fluid'>");
		out.println("<div class='navbar-header'>");
		out.println("<a class='navbar-brand' href='index.html'>Home</a></div>");
		out.println("<div><ul class='nav navbar-nav'>");
		out.println("<li><a href='servletLimparCarrinho.jsp'> Limpar Carrinho</a></li>");
		out.println("</ul></div></div></nav>");
		out.println("<div class='container'>");
		out.println("<div class='row'><p>");
		out.println("<div class='col-md-offset-2 col-md-8'>");
		out.println("<div class='panel panel-default'>");
		
		if(session != null){
			Carrinho c = (Carrinho) session.getAttribute("carrinho");
			if(c != null){
				List<Produto> produtosCarrinho = c.getListaDeProdutos();
				
				out.println("<table class='table table-striped table-hover'>");
				out.println("<caption>Produtos no carrinho</caption>");
				out.println("<tr><th>Código</th><th>Produto</th><th>Valor</th><th>Quantidade</th><th>Preço</th></tr>");
				
				for (Produto p : produtosCarrinho) {
					out.println("<tr><td>"+p.getCod()+"</td><td>"+p.getNome()+"</td><td>"+p.getPreco()+"</td><td>"+p.getQtd()+"</td><td>"+p.getQtd()*p.getPreco()+"</td></tr>");	
				}
				out.println("</table>");
				out.println("</div></div></div></div>");
			
			}else{
				out.println("Sem produtos no carrinho");
			}			
			out.println("</div></div></div></div>");
			out.println("</body>");
			out.println("</hmtl>");
			
	}else{
		out.println("Sem produtos no carrinho");
		out.println("</div></div></div></div>");
		out.println("</body>");
		out.println("</body>");
		out.println("</hmtl>");
		
	}
		
  }	
}
