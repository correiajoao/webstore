<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Cadastro</title>
	<link href="css/bootstrap.css" rel="stylesheet" media="screen">
	<!--<link href="css/loginAdministrador.css" rel="stylesheet" media="screen">-->
	<link href="css/webstore.css" rel="stylesheet" media="screen">
</head>
<body>

  <script type="text/javascript" src="javascript/jquery-1.11.2.js"></script>	
  <script src="javascript/cadastroProduto.js" type="text/javascript"></script>

<%@include file="navbar.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-md-offset-3 col-md-6">
				<p>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Dados da Compra</h3>
					</div>
					<div class="panel-body">
						<form action="servletFinalizarCompra.jsp" method="post">
							<div class="form-group">
								<label>Nome Completo</label>
								<input type="text" name="nome" class="form-control">
							</div>
							<div class="form-group">
								<label>Endereço</label>
								<input type="text" name="endereco" class="form-control">
							</div>							
							<input type="submit" value="Enviar" class="btn btn-success"> 
						</form>
					</div>
				</div>
				</p>
			</div>
		</div>
	</div>
<script src="javascript/bootstrap.js"></script>

</body>
</html>