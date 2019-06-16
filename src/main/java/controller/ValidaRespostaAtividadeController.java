package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Aluno;
import entity.Atividade;
import entity.AtividadeAtiva;
import entity.Aula;
import entity.AulaAtiva;
import entity.Curso;
import entity.CursoAtivo;

@WebServlet("/view/validaRespostaAtividade")
public class ValidaRespostaAtividadeController extends HttpServlet {

	private static final long serialVersionUID = -7256471732621522214L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) {
	
		HttpSession sessao = req.getSession(true);
		AtividadeController atividadeController = new AtividadeController();
		
		String resposta = req.getParameter("resposta");
		
		Atividade atividade = (Atividade) sessao.getAttribute("Atividade");
		int codAtividade = atividade.getCodAtividade();
		
		atividade = atividadeController.getById(codAtividade);
		atividade.setCodAtividade(codAtividade); 
		
		if (resposta.equals(atividade.getResposta())) {
		
			req.setAttribute("mensagem", "Resposta correta");

			AtividadeAtivaController atividadeAtivaController = new AtividadeAtivaController();
			
			Aluno aluno = (Aluno) sessao.getAttribute("Aluno");
			Curso curso = (Curso) sessao.getAttribute("Curso");
			Aula aula = (Aula) sessao.getAttribute("Aula");
			
			CursoAtivo cursoAtivo = new CursoAtivo();
			
			cursoAtivo.setCurso(curso);
			cursoAtivo.setAluno(aluno);
			
			AulaAtiva aulaAtiva = new AulaAtiva();
			
			aulaAtiva.setCursoAtivo(cursoAtivo);
			aulaAtiva.setAula(aula);
			
			AtividadeAtiva atividadeAtiva = new AtividadeAtiva();
			
			atividadeAtiva.setAulaAtiva(aulaAtiva);
			atividadeAtiva.setAtividade(atividade);
			atividadeAtiva.setEstatus("C");
			
			atividadeAtivaController.insertAtividadeAtiva(atividadeAtiva);
			
			try {
				req.getRequestDispatcher("./AtividadeAtiva.jsp").forward(req, res);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
			
		} else {
	
			req.setAttribute("erro", "Resposta incorreta");
			
			try {
				req.getRequestDispatcher("./AtividadeAtiva.jsp").forward(req, res);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
