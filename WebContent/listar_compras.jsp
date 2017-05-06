<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.*"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Compras</title>
<link href='css/bootstrap.css' rel='stylesheet' media='screen'>
<link href='css/webstore.css' rel='stylesheet' media='screen'>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<%
		List<Compra> compras = Banco.getInstance().getCompras();
	%>

	<%
		if (session != null) {

			//Administrador admin = (Administrador) session.getAttribute("administrador");

			if (admin != null) {
	%>
	<div class='container'>
		<div class='row'>
			<p>
			<div class='col-md-offset-2 col-md-8'>
				<div class='panel panel-default'>
					<table class='table table-striped table-hover'>
						<Caption>Compras</Caption>
						<tr>
							<th>Código</th>
							<th>Nome do cliente</th>
							<th>Endereço</th>
							<th>Total</th>
						</tr>
						<%
							for (Compra c : compras) {
						%>
						<tr>
							<td><%=c.getCod()%></td>
							<td><%=c.getNomeCliente()%></td>
							<td><%=c.getEndereco()%></td>
							<td><%= "R$ " + c.getTotal()%></td>
						</tr>
						<%
							}
						%>
					</table>
				</div>
			</div>
		</div>
	</div>
	<%
		}
	%>
	<%
		}
	%>

</body>
</html>