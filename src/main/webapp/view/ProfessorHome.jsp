<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="controller.CursoController"%>
<%@ page
	import="java.util.List, java.util.ArrayList, entity.Professor, entity.Curso"%>
<!DOCTYPE html>
<html lang="pt">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>WEBclass - Home - Professor</title>

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

	<%
		Professor professor = (Professor) session.getAttribute("Professor");
	%>

	<!-- Todos os elementos da página -->
	<div class="wrapper">
		<!-- Menu lateral  -->
		<nav id="sidebar">
			<div class="sidebar-header">
				<!-- Nome do Aluno que Logou -->
				<h3><%=professor.getNome()%></h3>
			</div>
			<!-- é uma lista de pra colocar o conteúdo dentro do menu lateral -->
			<ul class="list-unstyled components">
				<!-- Tipo do usuário logado e o número do id -->
				<p>
					ID:
					<%=professor.getCodProfessor()%></p>
				<!-- Menu do Professor -->
				<li><a href="ProfessorHome.jsp">Cursos Ministrados</a></li>
				<li><a href="CadastrarAula.jsp">Cadastro Aula</a></li>
				<li><a href="CadastrarAtividade.jsp">Cadastrar Atividade</a></li>
				<li><a href="telaCadastroConteudo.html">Cadastrar Conteudo</a></li>
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
							<li class="nav-item active"><a class="nav-link" href="#">perfil</a>
							</li>
							<li class="nav-item active"><a class="nav-link" href="#">Sair</a>
							</li>
						</ul>
					</div>
				</div>
			</nav>
			<!-- Fim do menu superior -->
			<!-- Conteúdo da página -->
			<div class="container">
				<!-- área de pesquisar/filtrar -->
				<div class="row">
					<!-- Campo de pesquisa -->
					<div class="col-md-6 col-sm-3">
						<input type="text" class="form-control" id="pesquisa"
							placeholder="Pesquisar">
					</div>
					<!-- Fim do campo de pesquisa -->
					<!-- Combo de filtro de categoria -->
					<div class="dropdown">
						<!-- Configuração do botão -->
						<button class="btn btn-secondary dropdown-toggle" type="button"
							id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">Categoria</button>
						<!-- itens do dropdown -->
						<div class="dropdown-menu" aria-labelledby="dropdownMenu2">
							<button class="dropdown-item" type="button">Ação</button>
							<button class="dropdown-item" type="button">Another Ação</button>
							<button class="dropdown-item" type="button">Something
								else here</button>
						</div>
					</div>
					<!-- Fim do combo de filtro de categoria -->
				</div>
				<!-- Fim da área de pesquisa -->
				<!-- Tag que faz a linha de divisão -->
				<hr />

				<!--Listar todos os cursos cadastrados>
				<!--  Área dos Cards-->
				<div class="row ">
					<%
						CursoController cursoController = new CursoController();

						List<Curso> cursos = new ArrayList<Curso>();

						//Armazena em Cursos todas as entidades de Curso recebidades de cursoController.getAll();
						cursos = cursoController.getAllByProfessor(professor);

						//Para cada entidade da Lista cria um card de Curso
						for (Curso curso : cursos) {
					%>


					<!--  Começo coluna individual do card-->
					<div class="col-md-4 col-sm-4 mt-3">
						<!--  Card-->
						<form action="./cursoProfessor" method="get">
						<div class="card">
							<!--  Imagem do card-->
							<img class="card-img-top" alt="Card header image"
								src="https://placeimg.com/640/480/nature">
							<!--  Corpo do card-->
							<div class="card-body">
								<h5 class="card-title"><%=curso.getNomeCurso()%></h5>
								<p class="card-text"><%=curso.getDescricao()%></p>
							</div>
							<!-- Fim do corpo do card-->
							<!-- Botão do card -->
							<div class="row card-body justify-content-center">
								<button type="submit" class="btn btn-primary" name="codCurso"
									value="<%=curso.getCodCurso()%>">Acessar</button>
							</div>
							<!-- Fim do botão do card -->
						</div>
						<!-- Fim do card -->
						</form>
					</div>
					<!--  Fim coluna individual do card-->
					<%
						}
					%>
				</div>
				<!--  Fim do Corpo da página -->
			</div>
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