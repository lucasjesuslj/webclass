package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.Aluno;
import entity.Aula;
import entity.AulaAtiva;
import entity.Curso;
import entity.CursoAtivo;
import exception.AulaAtivaDAOException;

@WebServlet("/view/atualizarEstatusAulaAtiva")
public class AtualizarEstatusAulaAtivaController extends HttpServlet {

	private static final long serialVersionUID = -224903788847961303L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		
		HttpSession sessao = req.getSession(true);
		AulaAtivaController aulaAtivaController = new AulaAtivaController();
		
		Curso curso = (Curso) sessao.getAttribute("Curso");
		Aluno aluno = (Aluno) sessao.getAttribute("Aluno");
		Aula aula = (Aula) sessao.getAttribute("Aula");
		
		CursoAtivo cursoAtivo = new CursoAtivo();
		
		cursoAtivo.setAluno(aluno);
		cursoAtivo.setCurso(curso);
		
		AulaAtiva aulaAtiva = new AulaAtiva();
		
		aulaAtiva.setCursoAtivo(cursoAtivo);
		aulaAtiva.setAula(aula);
		
		try {

			aulaAtivaController.updateStatus(aulaAtiva, "C");

			req.setAttribute("mensagem", "Aula concluída com sucesso");

		} catch (AulaAtivaDAOException e) {
			req.setAttribute("erro", e.getMessage());
		} finally {
			try {
				req.getRequestDispatcher("./AulaAtiva.jsp").forward(req, res);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}

}
