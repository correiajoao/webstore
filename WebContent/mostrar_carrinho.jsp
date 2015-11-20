<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Carrinho c = (Carrinho) session.getAttribute("carrinho");
%>
<% if(session != null && c != null) { %>
<% List<Produto> produtosCarrinho = c.getListaDeProdutos(); %>
	<table border='1'>
		<caption>Produtos no carrinho</caption>
		<tr>
			<th>Código</th>
			<th>Produto</th>
			<th>Valor</th>
			<th>Quantidade</th>
			<th>Preço</th>
		</tr>
		<% for (Produto p : produtosCarrinho) { %>
			<tr>
				<td><%=p.getCod()%></td>
				<td><%=p.getNome()%></td>
				<td><%=p.getPreco()%></td>
				<td><%=p.getQtd()%></td>
				<td><%=p.getQtd()*p.getPreco()%></td>
			</tr>	
		<% } %>
	</table>
<% } else{ %>
	Sem produtos no carrinho
<% } %>		

<a href='servletLimparCarrinho.jsp'> Limpar Carrinho</a>
<a href='index.html'> Página inicial</a>

</body>
</html>