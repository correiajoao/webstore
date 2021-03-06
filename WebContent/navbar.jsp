<%@ page import="model.*" %>
<%@ page import="java.util.List" %>

<% Administrador admin = (Administrador) session.getAttribute("administrador");%>

<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="index.jsp">Home</a>
		</div>
		<div>
			<ul class="nav navbar-nav">
				<li><a href="listar_produtos.jsp">Listar Produtos</a></li>		
				<% if (admin != null) { %>
					<li><a href="cadastrar_produtos.jsp">Cadastrar Produtos</a></li>
					<li><a href="listar_compras.jsp">Compras</a></li>
				<% }  else {%>
					<li><a href="mostrar_carrinho.jsp" class="botao-carrinho">Mostrar Carrinho</a></li>
				<% } %>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<% if (admin == null) { %>
					<li><a href="login_administrador.jsp">Administrador</a></li>
				<% } else {%>
					<li><a href="servletLogoutAdministrador.jsp">Logout</a></li>					
				<% } %>
			</ul>
		</div>
	</div>
</nav>  