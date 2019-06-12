package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.Curso;
import exception.CursoDAOException;

@WebServlet("/view/atualizarEstatusCurso")
public class AtualizarEstatusCursoController extends HttpServlet {

	private static final long serialVersionUID = -445831654984935296L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) {

		HttpSession sessao = req.getSession(true);

		Curso curso = (Curso) sessao.getAttribute("Curso");
		String estatus = req.getParameter("estatus");

		if (curso != null) {

			try {

				CursoController cursoController = new CursoController();

				cursoController.updateEstatus(curso, estatus);

				req.setAttribute("mensagem", "Curso Habilitado com sucesso");

			} catch (CursoDAOException e) {
				req.setAttribute("erro", e.getMessage());
			} finally {
				try {
					req.getRequestDispatcher("./CoordenadorCurso.jsp").forward(req, res);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}

		}

	}
}
