package controller;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.Aula;

@WebServlet("/view/aulaProfessor")
public class GetAulaProfessorController extends HttpServlet {

	private static final long serialVersionUID = -6507061128245099732L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) {

		AulaController aulaController = new AulaController();
		
		int codAula = Integer.parseInt(req.getParameter("codAula"));
		HttpSession sessao = req.getSession(true);

		Aula aula = new Aula();

		aula = aulaController.getById(codAula);
		
		aula.setCodAula(codAula);
		
		sessao.setAttribute("Aula", aula);

		try {
			res.sendRedirect("./ProfessorAula.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
