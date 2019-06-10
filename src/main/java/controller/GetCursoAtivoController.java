package controller;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.Curso;

@WebServlet("/view/cursoAtivo")
public class GetCursoAtivoController extends HttpServlet{
 
	private static final long serialVersionUID = 9158587986771466673L;

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
