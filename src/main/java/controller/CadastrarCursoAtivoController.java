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

@WebServlet("/view/cadastrarCursoAtivo")
public class CadastrarCursoAtivoController extends HttpServlet {

	private static final long serialVersionUID = -821009456484856079L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) {

		HttpSession sessao = req.getSession(true);

		CursoAtivoController cursoAtivoController = new CursoAtivoController();
 		
		CursoAtivo cursoAtivo = new CursoAtivo();
		
		Curso curso = (Curso) sessao.getAttribute("Curso");
		Aluno aluno = (Aluno) sessao.getAttribute("Aluno");
		
		cursoAtivo.setCurso(curso);
		cursoAtivo.setAluno(aluno);
		
		try {
			cursoAtivoController.insertCursoAtivo(cursoAtivo);
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
