<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listagem de Produtos</title>
<link href='css/bootstrap.css' rel='stylesheet' media='screen'>
<link href='css/webstore.css' rel='stylesheet' media='screen'>
</head>
<body>
<%@include file="navbar.jsp" %>
<% List<Produto> produtos = Banco.getInstance().getProdutos();%>

<%
if (session != null) {
	
	//Administrador admin = (Administrador) session.getAttribute("administrador");
	
	if (admin != null) { %>				
		
	<div class='container'>
		<div class='row'><p>
			<div class='col-md-offset-2 col-md-8'>
				<div class='panel panel-default'>
					<table class='table table-striped table-hover'>						
						<Caption>Produtos</Caption>	
						<tr><th>Código</th><th>Imagem</th><th>Nome</th><th>Descrição</th><th>Preço</th></tr>
						<% for (Produto p : produtos) { %>
							<tr><td><%=p.getCod()%></td><td><img class="product" src="<%=p.getImagem()%>" /></td><td><%=p.getNome()%></td><td><%=p.getDescricao()%></td><td><%="R$ " + p.getPreco()%></td></tr>
						<% } %>
					</table>
				</div>
			</div>
		</div>
	</div>
<% } else { %>
	
	<div class='container'>
		<div class='row'><p>
			<div class='col-md-offset-2 col-md-8'>
				<div class='panel panel-default'>
					<table class='table table-striped table-hover'>					
						<Caption>Produtos</Caption>	
						<tr><th>Código</th><th>Imagem</th><th>Nome</th><th>Descrição</th><th>Preço</th><th>Compra</th></tr>
						<% for (Produto p : produtos) { %>
							<tr><td><%=p.getCod()%></td><td><img class="product" src="<%=p.getImagem()%>"/></td><td><%=p.getNome()%></td><td><%=p.getDescricao()%></td><td><%="R$ " + p.getPreco()%></td><td><form action='servletAddCarinho.jsp'> <input type='hidden' name='id' value='<%=p.getCod()%>'><input type='submit' value='Comprar' class='btn btn-xs btn-primary'></form></td></tr>
						<% } %>
					</table>
				</div>
			</div>
		</div>
	</div>
<% } %>
<% } else { %>
	
	<div class='container'>
		<div class='row'><p>
			<div class='col-md-offset-2 col-md-8'>
				<div class='panel panel-default'>
					<table class='table table-striped table-hover'>
						<Caption>Produtos</Caption>	
						<tr><th>Código</th><th>Imagem</th><th>Nome</th><th>Descrição</th><th>Preço</th><th>Compra</th></tr>
						<%for (Produto p : produtos) { %>
							<tr><td><%=p.getCod()%></td><td><img class="product" src="<%=p.getImagem()%>" /><td><%=p.getNome()%></td><td><%=p.getDescricao()%></td><td><%="R$ " + p.getPreco()%></td></tr>
						<%} %>
					</table>
				</div>
			</div>
		</div>
	</div>
<% }%>
	
</body>
</html>