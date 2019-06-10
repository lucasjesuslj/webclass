<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WEBclass - Cursos Online</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>WEBclass - Login</title>
</head>
<body>
	<style>
@import
	url('https://fonts.googleapis.com/css?family=Ranga&display=swap');

.nome-site>span {
	font-family: 'Ranga', cursive;
}

.head-login {
	text-align: center;
}

.alinhamento-botao {
	text-align: center;
}

.alinhamento-form {
	margin-top: 5%;
}
</style>
	<!--Criando o WebClass -->
<body>

	<!--  Começo do Titulo -->
	<div class="row">
		<div class="col-sm-12 col-md-12 head-login">
			<h1 class="nome-site">
				WEB<span>class</span>
			</h1>
		</div>
	</div>
	<!--  Fim do Titulo -->

	<div class="row justify-content-center alinhamento-form">
		<div class="col-sm-4 col-md-4 justify-content-center">
			<!-- Criação das abas -->
			<div class="alinhamento-form ">
				<ul class="nav nav-tabs justify-content-center" id="myTab"
					role="tablist">

					<!-- Primeira aba -->
					<li class="nav-item"><a class="nav-link active" id="home-tab"
						data-toggle="tab" href="#home" role="tab" aria-controls="home"
						aria-selected="true">Login</a></li>

					<!-- Segunda aba -->
					<li class="nav-item"><a class="nav-link" id="profile-tab"
						data-toggle="tab" href="#profile" role="tab"
						aria-controls="profile" aria-selected="false">Cadastrar</a></li>
				</ul>
			</div>
			<!-- Fim da criação das abas -->

			<!-- Começo do LOGIN -->
			<div class="tab-content" id="myTabContent">
				<div class="tab-pane fade show active" id="home" role="tabpanel"
					aria-labelledby="home-tab">

					<!-- Aqui os dados são passados para verificação -->
					<form class="alinhamento-form" action="./login" method="post">

						<!-- Campo Email -->
						<div class="form-group row ">
							<label class="col-sm-12 col-form-label" for="email">
								E-mail </label>
							<div class="col-sm-12">
								<input type="email" name="email" class="form-control" id="email"
									required />
							</div>
						</div>

						<!-- Campo Senha -->
						<div class="form-group row">
							<label class="col-sm-12 col-form-label" for="password">
								Senha </label>
							<div class="col-sm-12">
								<input type="password" name="senha" class="form-control"
									id="password" required />
							</div>

							<!-- Campo Tipo -->
							<label class="col-sm-auto col-form-label" for="categoria">Tipo</label>
							<div class="col-sm-12">
								<select class="form-control" name="usuario" id="selectCategoria">
									<option value="1">Aluno</option>
									<option value="2">Professor</option>
									<option value="3">Coordenador</option>
								</select>
							</div>
						</div>

           				<!-- Mostra mensagem de sucesso caso o cadastro seja efetuado com sucesso -->
						<!-- Mostra mensagem de erro caso seja lançada uma exceção -->
						<% 
						if (request.getAttribute("mensagem") != null) {
						
					    %>
		 
					    <div class="alert alert-success alert-dismissible fade show"
							role="alert">
							<%=request.getAttribute("mensagem")%>
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
			
						<%
						
						request.removeAttribute("mensagem");
						}
						
						else if (request.getAttribute("erro") != null) {
						%>
						<div class="alert alert-danger alert-dismissible fade show"
							role="alert">
							<%=request.getAttribute("erro")%>
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<%
							request.removeAttribute("erro");
							}
						%>

						<!-- Botão Login -->
						<div
							class="form-group row justify-content-center alinhamento-botao">
							<div class="col-md-4 ">
								<button type="submit" class="btn btn-primary">Login Now</button>
							</div>
						</div>
						<div
							class="form-group row justify-content-center alinhamento-botao">

						</div>
					</form>
				</div>
				<!-- Fim do LOGIN -->

				<!-- Começo do CADASTRO -->
				<div class="tab-pane fade" id="profile" role="tabpanel"
					aria-labelledby="profile-tab">

					<!-- Aqui os dados são passados para criação -->
					<form class="alinhamento-form" action="./cadastrarUsuario"
						method="post">

						<!-- Campo Nome -->
						<div class="form-group row">
							<label class="col-sm-12 col-form-label" for="nome">Nome
								Completo</label>
							<div class="col-sm-12">
								<input type="text" name="nome" class="form-control" id="nome"
									required />
							</div>
						</div>

						<!-- Campo Email -->
						<div class="form-group row">
							<label class="col-sm-12 col-form-label" for="email">E-mail</label>
							<div class="col-sm-12">
								<input type="email" name="email" class="form-control" id="email"
									required />
							</div>
						</div>

						<!-- Campo Senha -->
						<div class="form-group row">
							<label class="col-sm-12 col-form-label" for="password">Senha</label>
							<div class="col-sm-12">
								<input type="password" name="senha" class="form-control"
									id="password" required />
							</div>

							<!-- Campo Tipo -->
							<label class="col-sm-auto col-form-label" for="categoria">Tipo</label>
							<div class="col-sm-12">
								<select class="form-control" name="usuario" id="selectCategoria">
									<option value="1">Aluno</option>
									<option value="2">Professor</option>
									<option value="3">Coordenador</option>
								</select>
							</div>
						</div>

						<!-- Botão Cadastrar -->
						<div
							class="form-group row justify-content-center alinhamento-botao">
							<div class="col-md-4 ">
								<button type="submit" class="btn btn-primary">Cadastrar</button>
							</div>
						</div>

					</form>
				</div>
				<!-- Fim do CADASTRO -->

			</div>
		</div>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>


</body>
</html>