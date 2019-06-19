<%@page import="controller.CursoAtivoController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, java.util.ArrayList, entity.Aluno, entity.CursoAtivo, entity.Curso, controller.AulaController, controller.AulaAtivaController"%>
<!DOCTYPE html>
<html lang="pt">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>WEBclass - Cursos Ativos</title>

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
	<!-- Todos os elementos da p�gina -->
	<div class="wrapper">
		<!-- Menu lateral  -->
		<nav id="sidebar">
			<div class="sidebar-header">
			
				<!-- Nome do Aluno que Logou -->
				<%
					Aluno aluno = (Aluno) session.getAttribute("Aluno");
				%>
				<h3><%=aluno.getNome()%></h3>
				
			</div>
			<!-- � uma lista de pra colocar o conte�do dentro do menu lateral -->
			<ul class="list-unstyled components">
			
				<!-- Tipo do usu�rio logado e o n�mero do id -->
				<p>Aluno#<%=aluno.getCodAluno()%></p>
				
				<!-- Menu do Aluno -->
				<li><a
					href="AlunoHome.jsp">Cursos</a>
				</li>
				<li class="active"><a
					href="CursosAtivos.jsp">Meus
						Cursos</a></li>
			</ul>
		</nav>
		<!-- Fim do menu lateral  -->

		<!-- Corpo da p�gina  -->
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
					<!-- Bot�o de Ativar o menu lateral -->
					<button type="button " id="sidebarCollapse" class="btn btn-light">
						<i class="fa fa-bars"></i>
					</button>
					<!-- Bot�o do menu superior quando est� no mobile -->
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
							<li class="nav-item active"><a class="nav-link" href="PerfilAluno.jsp">Perfil</a>
							</li>
							<li class="nav-item active"><a class="nav-link" href="Sair.jsp">Sair</a>
							</li>
						</ul>
					</div>
				</div>
			</nav>
			<!-- Fim do menu superior -->
			<!-- Conte�do da p�gina -->
			<div class="container">
				<!-- �rea de pesquisar/filtrar -->
				<div class="row">
					<div class="col-md-12">
						<p>Meus Cursos</p>
					</div>
					<!-- Campo de pesquisa -->
					<div class="col-md-8 col-sm-3">
						<input type="text" class="form-control" id="pesquisa"
							placeholder="Pesquisar">
					</div>
					<!-- Fim do campo de pesquisa -->
					<!-- Combo de filtro de categoria -->
					<div class="dropdown col-md-4 col-sm-2">
						<!-- Configura��o do bot�o -->
						<button class="btn btn-secondary dropdown-toggle" type="button"
							id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">Categoria</button>
						<!-- itens do dropdown -->
						<div class="dropdown-menu" aria-labelledby="dropdownMenu2">
							<button class="dropdown-item" type="button">A��o</button>
							<button class="dropdown-item" type="button">Another A��o</button>
							<button class="dropdown-item" type="button">Something
								else here</button>
						</div>
					</div>
					<!-- Fim do combo de filtro de categoria -->
				</div>
				<!-- Fim da �rea de pesquisa -->
				<!-- Tag que faz a linha de divis�o -->
				<hr />


				<!--  �rea dos Cards-->
				<div class="row" style="margin-bottom:50px;">

					<%
						CursoAtivoController cursoAtivoController = new CursoAtivoController();
						AulaController aulaController = new AulaController();
						AulaAtivaController aulaAtivaController = new AulaAtivaController();						
						
						List<CursoAtivo> cursosAtivos = new ArrayList<CursoAtivo>();

						cursosAtivos = cursoAtivoController.getAllByAluno(aluno);

						for (CursoAtivo cursoAtivo : cursosAtivos) {
							
						cursoAtivo.setAluno(aluno);
					%>

					<!--  Come�o coluna individual do card-->
					<div class="col-md-4 col-sm-4 mt-3">
					<form action="./cursoAtivo" method="get">
						<!--  Card-->
						<div class="card">
							<!--  Imagem do card-->
							<img class="card-img-top" alt="Card header image"
								src="https://placeimg.com/640/480/nature">
							<!--  Corpo do card-->
							<div class="card-body">
								<div class="row">
									<div class="col-md-7 col-sm-10">
										<h5 class="card-title"><%=cursoAtivo.getCurso().getNomeCurso()%></h5>
									</div>
									<div class="col-md-5 col-sm-2">
										<h6>
										    <!--  Mostra: Aulas em progresso / Aulas do Curso-->
											<span class="qtd-aula"><%=aulaAtivaController.getCountByCursoAtivo(cursoAtivo)%></span>/<%=aulaController.getCountByCurso(cursoAtivo.getCurso())%> aulas</h6>
									</div>
									<div class="col-md-12 col-sm-12">
										<h6>�ltima atualiza��o:</h6>
										<p><%=cursoAtivo.getCurso().getDataAlteracao()%></p>
									</div>
								</div>
							</div>
							<!-- Fim do corpo do card-->
							
							<!-- Bot�o do card -->
							<div class="row card-body justify-content-center">
								<!-- <a href="#" class="btn btn-card">Acessar</a> -->
								<button type="submit" class="btn btn-primary" name="codCurso" value="<%=cursoAtivo.getCurso().getCodCurso()%>">Acessar</button>
							</div>
							<!-- Fim do bot�o do card -->
							
						</div>
						<!-- Fim do card -->
					</form>
					</div>
					<!--  Fim coluna individual do card-->
				<!-- </div> --> 
				<%
					}
				%>
				<!--  Fim �rea dos cards -->
			</div>
			<!--  Fim do Corpo da p�gina -->

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