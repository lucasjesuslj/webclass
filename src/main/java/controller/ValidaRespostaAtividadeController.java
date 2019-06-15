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
import entity.Aula;
import entity.AulaAtiva;
import entity.Curso;
import entity.CursoAtivo;
import exception.AulaAtivaDAOException;

@WebServlet("/view/atividadeAtiva")
public class ValidaRespostaAtividadeController extends HttpServlet {

	private static final long serialVersionUID = -7256471732621522214L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) {
	
		HttpSession sessao = req.getSession(true);
		AtividadeController atividadeController = new AtividadeController();
		
		String resposta = req.getParameter("resposta");
		
		Curso curso = (Curso) sessao.getAttribute("Curso");
		Aluno aluno = (Aluno) sessao.getAttribute("Aluno");
		Aula aula = (Aula) sessao.getAttribute("Aula");
		Atividade atividade = (Atividade) sessao.getAttribute("Atividade");
		
		atividade = atividadeController.getById(atividade.getCodAtividade());
		
		if (resposta.equals(atividade.getResposta())) {
		
			req.setAttribute("mensagem", "Resposta correta");

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
