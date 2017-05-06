<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Meu Carrinho</title>
<link href='css/bootstrap.css' rel='stylesheet' media='screen'>
<link href='css/webstore.css' rel='stylesheet' media='screen'>
</head>
<body>
<%@include file="navbar.jsp" %>
<%
Carrinho c = (Carrinho) session.getAttribute("carrinho");
%>
<% if(session != null && c != null) { %>
<% List<Produto> produtosCarrinho = c.getListaDeProdutos(); %>
	<div class='container'>
		<div class='row'><p>
			<div class='col-md-offset-2 col-md-8'>
				<div class='panel panel-default'>
					<table class="table table-striped table-hover">
						<caption>Produtos no carrinho 
							<a href='servletLimparCarrinho.jsp' class="btn btn-danger btn-xs navbar-right" style="margin-right: 0px"> 
								Limpar Carrinho
							</a>
							<a href='formulario_compra.jsp' class="btn btn-success btn-xs navbar-right" style="margin-right: 5px"> 
								Finalizar Compra
							</a>
						</caption>
						<tr>
							<th>Código</th>
							<th>Imagem</th>
							<th>Produto</th>
							<th>Valor</th>
							<th>Quantidade</th>
							<th>Total</th>
						</tr>
						<% for (Produto p : produtosCarrinho) { %>
							<tr>
								<td><%=p.getCod()%></td>
								<td><img class="product" src="<%=p.getImagem()%>"/></td>
								<td><%=p.getNome()%></td>
								<td><%=p.getPreco()%></td>
								<td><%=p.getQtd()%></td>
								<td><%= "R$ " + p.getQtd()*p.getPreco()%></td>
							</tr>	
						<% } %>
					</table>
				</div>
				<a href='servletLimparCarrinho.jsp' class="btn btn-danger btn-xs navbar-right" style="margin-right: 22px"> 
					Limpar Carrinho
				</a>
				<a href='formulario_compra.jsp' class="btn btn-success btn-xs navbar-right" style="margin-right: 5px"> 
					Finalizar Compra
				</a>
			</div>
		</div>
	</div>
	<% } else{ %>
	<div class='container'>
		<div class='row'><p>
			<div class='col-md-offset-2 col-md-8'>
				Sem produtos no carrinho<a href='index.jsp'> Página inicial</a>
			</div>
		</div>
	</div>
	<% } %>		
</body>
</html>