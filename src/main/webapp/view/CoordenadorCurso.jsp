<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="controller.CursoController"%>
<%@page import="controller.AulaController"%>
<%@page import="entity.Aula"%>
<%@ page
	import="java.util.List, java.util.ArrayList, entity.Coordenador, entity.Curso"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WEBclass - Home - Coordenador</title>
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
<title>WEBclass - Home - Aluno</title>

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
				Curso curso = (Curso) session.getAttribute("Curso");
			%>
			<h3><%=coordenador.getNome()%></h3>
		</div>
		<!-- é uma lista de pra colocar o conteúdo dentro do menu lateral -->
		<ul class="list-unstyled components">
			<!-- Tipo do usuário logado e o número do id -->
			<p>
				Coordenador - ID:
				<%=coordenador.getCodCoordenador()%></p>
			<!-- Menu do Aluno -->
			<li class="active"><a href="#homeSubmenu" data-toggle="collapse"
				aria-expanded="false" class="dropdown-toggle">Cursos</a>
				<ul class="collapse list-unstyled" id="homeSubmenu">
					<li><a href="CoordenadorHome.jsp">Cursos Cadastrados</a></li>
					<li class="active"><a href="CadastrarCurso.jsp">Cadastrar
							Novo</a></li>
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

				<!-- Fim do título -->
				<!-- Tag que faz a linha de divisão -->
				<hr />

				<!-- Mostra mensagem de Erro caso o cadastro de Curso Ativo lance uma exceção OU -->
				<!-- Mostra mensagem de confirmação caso o CursoAtivo seja cadastrado com sucesso -->
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

				<!--  Área dos Cards-->
				<div class="row ">
					<div class="col-md-12 mb-2">
						<img class="card-img-top" alt="Card header image"
							src="https://placeimg.com/640/480/nature" width="1110"
							height="400">
					</div>
					<div class="col-md-12">
						<div class="row">
							<div class="col-sm-4">
								<!-- Armazena no objeto cursoInfo as informações do curso recuperadas pelo codCurso-->
								<%
									CursoController cursoController = new CursoController();

									Curso cursoInfo = new Curso();

									cursoInfo = cursoController.getById(curso.getCodCurso());
									cursoInfo.setCodCurso(curso.getCodCurso());
								%>
								<h3><%=cursoInfo.getNomeCurso()%></h3>
								<div class="col-sm-2 offset-6">
								<!--  Verifica se o curso está Desabilitado para mostrar o botão -->
								<%
									if ("D".equals(cursoInfo.getEstatus())) {
								%>

								<form action="./atualizarEstatusCurso" method="post">
									<button type="submit" name="estatus" value="H"
										class="btn  btn-primary">Habilitar</button>
								</form>

								<%
									}
								%>

							</div>
						</div>
						</div>
						<div class="alinhamento-form ">
							<ul class="nav nav-tabs justify-content-center" id="myTab"
								role="tablist">
								<li class="nav-item"><a class="nav-link active"
									id="home-tab" data-toggle="tab" href="#home" role="tab"
									aria-controls="home" aria-selected="true">Aulas</a></li>
								<li class="nav-item"><a class="nav-link" id="profile-tab"
									data-toggle="tab" href="#profile" role="tab"
									aria-controls="profile" aria-selected="false">Descrição</a></li>
							</ul>
						</div>
						<div class="tab-content" id="myTabContent">
							<div class="tab-pane fade show active" id="home" role="tabpanel"
								aria-labelledby="home-tab">
								<div class="container" style="margin-top: 30px">

									<%
										AulaController aulaController = new AulaController();

										List<Aula> aulas = new ArrayList<Aula>();

										aulas = aulaController.getByCurso(curso);

										for (Aula aula : aulas) {
									%>
									<form action="./cursoAtivo" method="post">
										<ul class="list-group">
											<!--  <a href="" target="_blank"> -->
											<!--	<li class="list-group-item d-flex justify-content-between align-items-center"> -->
											<p><%=aula.getDescricao()%></p>
											<button type="submit">
												<i class="fa fa-angle-right" aria-hidden="true">Acessar</i>
											</button>
											<!--	<i class="fa fa-angle-right" aria-hidden="true"></i> -->
											</li>
											</a>
										</ul>
									</form>
									<%
										}
									%>
								</div>
							</div>
							<div class="tab-pane fade" id="profile" role="tabpanel"
								aria-labelledby="profile-tab">
								<p><%=cursoInfo.getDescricao()%></p>
							</div>
						</div>
					</div>
				</div>
				<!--  Fim Área dos cards -->
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