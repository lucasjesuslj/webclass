<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entity.Curso"%>
<%@page import="entity.Professor"%>
<%@page import="entity.Aula"%>
<%@page import="entity.Atividade"%>
<%@page import="entity.CursoAtivo"%>
<%@page import="entity.AulaAtiva"%>
<%@page import="entity.AtividadeAtiva"%>
<%@page import="controller.CursoController"%>
<%@page import="controller.AtividadeController"%>
<%@page import="controller.AulaAtivaController"%>
<%@page import="controller.AtividadeAtivaController"%>
<%@page import="java.util.List, java.util.ArrayList, entity.Aluno, entity.Curso"%>
<!DOCTYPE html>
<html lang="pt">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>WEBclass - Atividade - Aluno </title>

    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="style-home-aluno.css">

    <!-- Font Awesome JS -->
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>
</head>

<body>

	<!-- Recupera a inst�ncia do Aluno criado na sess�o e o curso acessado pelo bot�o "Acessar"-->
	<%
		Professor professor = (Professor) session.getAttribute("Professor");
		Curso curso = (Curso) session.getAttribute("Curso");
		Aula aula = (Aula) session.getAttribute("Aula");
		Atividade atividade = (Atividade) session.getAttribute("Atividade");
	%>

    <!-- Todos os elementos da p�gina -->
    <div class="wrapper">
         <!-- Menu lateral  -->
         <nav id="sidebar">
            <div class="sidebar-header">
                <!-- Nome do Professor que Logou -->
					<h3><%=professor.getNome()%></h3>
            </div>
            <!-- � uma lista de pra colocar o conte�do dentro do menu lateral -->
            <ul class="list-unstyled components">
                <!-- Tipo do usu�rio logado e o n�mero do id -->
                <p>
					Professor - ID:
					<%=professor.getCodProfessor()%></p>
				<!-- Menu do Professor -->
				<li><a href="ProfessorHome.jsp">Cursos Ministrados</a></li>
				<li><a href="CadastrarAula.jsp">Cadastro Aula</a></li>
				<li><a href="CadastrarAtividade.jsp">Cadastrar Atividade</a></li>
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
                            <h1 class="nome-site">WEB<span>class</span></h1>
                        </li>
                    </ul>
                    <!-- Bot�o de Ativar o menu lateral -->
                    <button type="button " id="sidebarCollapse" class="btn btn-light" >
                        <i class="fa fa-bars"></i>
                    </button>
                    <!-- Bot�o do menu superior quando est� no mobile -->
                    <button class="btn btn-light d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <i class="fa fa-ellipsis-v"></i>
                    </button>
                    <!-- itens do menu superior -->
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="nav navbar-nav ml-auto">
                            <li class="nav-item active">
                                <a class="nav-link" href="PerfilProfessor.jsp">Perfil</a>
                            </li>
                            <li class="nav-item active">
                                <a class="nav-link" href="Sair.jsp">Sair</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <!-- Fim do menu superior -->
            <!-- Conte�do da p�gina -->
                        
            <div class="container" >
                <!-- �rea do t�tulo -->
                <div class="row">
                    <div class="col-md-12">
                        <p><%=atividade.getNome()%></p>
                    </div>
                </div>
                <!-- Fim ddo t�tulo -->
                <!-- Tag que faz a linha de divis�o -->
                <hr />
                
                <!-- Mostra mensagem de Erro caso o cadastro de Curso Ativo lance uma exce��o OU -->
				<!-- Mostra mensagem de confirma��o caso o CursoAtivo seja cadastrado com sucesso -->
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
                
                
                <div class="row ">
                    <div class="col-md-12 espamento-image">
                    </div>
                    <div class="col-md-12">
                        <p><%=atividade.getDescricao()%></p>
                        
                        </div>
                        </div> 
                </div>
                <!--  Fim �rea dos cards-->
            </div>
            <!--  Fim do Corpo da p�gina -->

    <!-- jQuery CDN - Slim version (=without AJAX) -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <!-- Popper.JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

    <script type="text/javascript">
        $(document).ready(function  () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
            });
        });
    </script>
</body>

</html>