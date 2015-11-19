package controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;

import model.Administrador;
import model.Banco;

/**
 * Servlet implementation class verificarAdministrador
 */
@WebServlet("/servletVerificarAdministrador.jsp")
public class servletVerificarAdministrador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletVerificarAdministrador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Administrador admin = new Administrador(email, senha);
		
		if(Banco.getInstance().verificarAdmin(admin)){
			System.out.println("Válido");
			session.setAttribute("administrador", admin);
			out.print("true");
		}else{
			System.out.println("Inválido");
			out.print("false");
		}
		
	}

}
