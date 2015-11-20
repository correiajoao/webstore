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
		out.println("</head>");
		out.println("<body>");
		
		if(session != null){
			Carrinho c = (Carrinho) session.getAttribute("carrinho");
			if(c != null){
				List<Produto> produtosCarrinho = c.getListaDeProdutos();
				
				out.println("<table border='1'>");
				out.println("<caption>Produtos no carrinho</caption>");
				out.println("<tr><th>Código</th><th>Produto</th><th>Valor</th><th>Quantidade</th><th>Preço</th></tr>");
				
				for (Produto p : produtosCarrinho) {
					out.println("<tr><td>"+p.getCod()+"</td><td>"+p.getNome()+"</td><td>"+p.getPreco()+"</td><td>"+p.getQtd()+"</td><td>"+p.getQtd()*p.getPreco()+"</td></tr>");	
				}
				out.println("</table>");
			
			}else{
				out.println("Sem produtos no carrinho");
			}
			out.println("<a href='servletLimparCarrinho.jsp'> Limpar Carrinho</a>");
			out.println("<a href='index.html'> Página inicial</a>");
			out.println("</body>");
			out.println("</body>");
			out.println("</hmtl>");
			
	}else{
		out.println("Sem produtos no carrinho");
		
		out.println("<a href='servletLimparCarrinho.jsp'> Limpar Carrinho</a>");
		out.println("<a href='index.html'> Página inicial</a>");
		out.println("</body>");
		out.println("</body>");
		out.println("</hmtl>");
		
	}
		
  }	
}
