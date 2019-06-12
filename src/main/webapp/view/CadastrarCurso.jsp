<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="controller.CategoriaController"%>
<%@ page
	import="java.util.List, java.util.ArrayList, entity.Coordenador, entity.Categoria, 
	entity.Professor, controller.ProfessorController"%>
<!DOCTYPE html>
<html lang="pt">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>WEBclass - Cadastrar Curso - Coordenador</title>

<!-- Bootstrap CSS CDN -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">
<!-- Our Custom CSS -->
<link rel="stylesheet" href="style-home-aluno.css">

<!-- Font Awesome JS -->
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"
	integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ"
	crossorigin="anonymous"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"
	integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY"
	crossorigin="anonymous"></script>
</head>

<body>
	<!-- Todos os elementos da página -->
	<div class="wrapper">
		<!-- Menu lateral  -->
		<nav id="sidebar">
			<div class="sidebar-header">
				<!-- Nome do Coordenador que Logou -->
				<%
					Coordenador coordenador = (Coordenador) session.getAttribute("Coordenador");
				%>
				<h3><%=coordenador.getNome()%></h3>
			</div>
			<!-- é uma lista de pra colocar o conteúdo dentro do menu lateral -->
			<ul class="list-unstyled components">
				<!-- ID usuário -->
				<p>ID: <%=coordenador.getCodCoordenador()%></p>
				<!-- Menu do Aluno -->
				<li class="active"><a href="#homeSubmenu"
					data-toggle="collapse" aria-expanded="false"
					class="dropdown-toggle">Cursos</a>
					<ul class="collapse list-unstyled" id="homeSubmenu">
						<li><a href="CoordenadorHome.jsp">Cursos Cadastrados</a>
						</li>
						<li class="active"><a href="CadastrarCurso.jsp">Cadastrar Novo</a></li>
					</ul></li>
				<li><a href="CadastrarCategoria.jsp">Cadastrar Categoria</a></li>
				<li><a href="CadastrarProfessor.jsp">Cadastrar Professor</a></li>
			</ul>
		</nav>
		<!-- Fim do menu lateral  -->

		<!-- Corpo da página  -->
		<div id="content">
			<!-- Menu superior -->
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="container-fluid">
					<!-- Lista do Logo/Nome -->
					<ul class="nav navbar-nav ml-auto">
						<li class="nav-item active">
							<h1 class="nome-site">
								WEB<span>class</span>
							</h1>
						</li>
					</ul>

					<!-- Botão de Ativar o menu lateral -->
					<button type="button " id="sidebarCollapse" class="btn btn-light">
						<i class="fa fa-bars"></i>
					</button>

					<!-- Botão do menu superior quando está no mobile -->
					<button class="btn btn-light d-inline-block d-lg-none ml-auto"
						type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<i class="fa fa-ellipsis-v"></i>
					</button>

					<!-- itens do menu superior -->
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="nav navbar-nav ml-auto">
							<li class="nav-item active"><a class="nav-link" href="#">Perfil</a>
							</li>
							<li class="nav-item active"><a class="nav-link"
								href="http://localhost:8080/WebClass/Login.jsp">Sair</a></li>
						</ul>
					</div>
				</div>
			</nav>
			<!-- Fim do menu superior -->
			<!-- Conteúdo da página -->
			<div class="container">
				<!-- área do título -->
				<div class="row">
					<div class="col-md-12">
						<p>Cadastrar Curso</p>
					</div>
				</div>
				<!-- Fim do título -->

				<!-- Mostra mensagem de Erro caso o cadastro de Curso lance uma exceção OU -->
				<!-- Mostra mensagem de confirmação caso o Curso seja cadastrado com sucesso -->
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
				
				<div class="alert alert-warning alert-dismissible fade show"
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

				<!-- Tag que faz a linha de divisão -->
				<hr />
				<!--  Área dos Cards-->
				<div class="row ">
					<div class="col-md-12 espamento-image">
						<img class="card-img-top" alt="Card header image"
							src="https://placeimg.com/640/480/nature" width="1110"
							height="350">
						<hr />
					</div>
					<div class="col-md-12">
						<form action="./cadastrarCurso" method="post">
							<div class="form-group row">
								<label class="col-sm-auto col-form-label" for="nomeCurso">Nome
									do Curso</label>
								<div class="col-sm-4">
									<input type="text" name="nomeCurso" class="form-control"
										id="nomeCurso">
								</div>

								<label class="col-sm-auto col-form-label" for="categoria">Categoria</label>
								<div class="col-sm-5">
									<select class="form-control" name="categoria"
										id="selectCategoria">

										<%
											CategoriaController categoriaController = new CategoriaController();

											List<Categoria> categorias = new ArrayList<Categoria>();

											categorias = categoriaController.getAll();

											for (Categoria categoria : categorias) {
										%>
										<option value="<%=categoria.getCodCategoria()%>"><%=categoria.getNome()%></option>
										<%
											}
										%>
									</select>
								</div>

							</div>
							<div class="form-group row">
								<label class="col-sm-auto col-form-label" for="duracaoMedia">Duração
									Média</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" name="duracao"
										id="duracaoMedia">
								</div>

								<label class="col-sm-auto col-form-label" for="nomeCurso">Professor
									Responsável</label>
								<div class="col-sm-4">
									<select class="form-control" name="professor"
										id="selectProfessor">
										<%
											ProfessorController professorController = new ProfessorController();

											List<Professor> professores = new ArrayList<Professor>();

											professores = professorController.getAll();

											for (Professor professor : professores) {
										%>

										<option value="<%=professor.getCodProfessor()%>"><%=professor.getNome()%></option>

										<%
											}
										%>
									</select>
								</div>
							</div>

							<div class="form-group row">
								<label class="col-sm-12 col-form-label" for="nomeCurso">Descrição</label>
								<div class="col-sm-12">
									<textarea class="form-control" name="descricao"
										id="exampleFormControlTextarea1" rows="5"></textarea>
								</div>
							</div>

							<div class="row">
								<div class="col-sm-12 espacamento-bottom ">
									<button type="submit" class="btn  btn-danger">Cancelar</button>
									<button type="submit" class="btn btn-success">Salvar</button>
								</div>
							</div>

						</form>
					</div>
				</div>
				<!--  Fim Área dos cards-->
			</div>
			<!--  Fim do Corpo da página -->

			<!-- jQuery CDN - Slim version (=without AJAX) -->
			<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
				integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
				crossorigin="anonymous"></script>
			<!-- Popper.JS -->
			<script
				src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
				integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
				crossorigin="anonymous"></script>
			<!-- Bootstrap JS -->
			<script
				src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
				integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
				crossorigin="anonymous"></script>

			<script type="text/javascript">
				$(document).ready(function() {
					$('#sidebarCollapse').on('click', function() {
						$('#sidebar').toggleClass('active');
					});
				});
			</script>
</body>

</html>