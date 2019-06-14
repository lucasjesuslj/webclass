package controller;

import java.io.IOException;
import java.util.List;
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

@WebServlet("/view/cadastrarCursoAtivo")
public class CadastrarCursoAtivoController extends HttpServlet {

	private static final long serialVersionUID = -821009456484856079L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) {

		HttpSession sessao = req.getSession(true);

		CursoAtivoController cursoAtivoController = new CursoAtivoController();
 		AulaController aulaController = new AulaController();
 		AulaAtivaController aulaAtivaController = new AulaAtivaController();
		
		CursoAtivo cursoAtivo = new CursoAtivo();
		
		Curso curso = (Curso) sessao.getAttribute("Curso");
		Aluno aluno = (Aluno) sessao.getAttribute("Aluno");
		
		cursoAtivo.setCurso(curso);
		cursoAtivo.setAluno(aluno);
		
		try {
			cursoAtivoController.insertCursoAtivo(cursoAtivo);
			
			//Insere 1 registro de AulaAtiva pra cada aula do Curso
			//com estatus 'P' (Em Progresso)
			List<Aula> aulas = aulaController.getByCurso(curso);
			
			for (Aula aula : aulas) {
				
				AulaAtiva aulaAtiva = new AulaAtiva();
				aulaAtiva.setCursoAtivo(cursoAtivo);
				aulaAtiva.setAula(aula);
				
				aulaAtivaController.insertAulaAtiva(aulaAtiva);
				
			}
			
			req.setAttribute("mensagem", "Matricula no Curso efetuada com sucesso");
			req.getRequestDispatcher("Curso.jsp").forward(req, res);
		} catch (ServletException | IOException io) {
			io.printStackTrace();
		}
				
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			res.sendRedirect("./Curso.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
