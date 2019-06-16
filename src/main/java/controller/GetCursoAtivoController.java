package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.Aluno;
import entity.Curso;
import entity.CursoAtivo;
import exception.CursoAtivoDAOException;

@WebServlet("/view/cursoAtivo")
public class GetCursoAtivoController extends HttpServlet{
 
	private static final long serialVersionUID = 9158587986771466673L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) {
	
		CursoAtivoController cursoAtivoController = new CursoAtivoController();
		
		HttpSession sessao = req.getSession(true);
		
		Aluno aluno = (Aluno) sessao.getAttribute("Aluno");
		Curso curso = (Curso) sessao.getAttribute("Curso");
		
		try {
			CursoAtivo cursoAtivo = cursoAtivoController.getByAlunoAndCurso(curso, aluno);
		} catch (CursoAtivoDAOException e) {
			try {
				req.setAttribute("erro", e.getMessage());
				req.getRequestDispatcher("./Curso.jsp").forward(req, res);
			} catch (ServletException | IOException ie) {
				ie.printStackTrace();
			}
		}
				
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		
		int codCurso = Integer.parseInt(req.getParameter("codCurso"));
		HttpSession sessao = req.getSession(true);
		
		Curso curso = new Curso();
		
		curso.setCodCurso(codCurso);
		
		sessao.setAttribute("Curso", curso);
		
		try {
			res.sendRedirect("./Curso.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
