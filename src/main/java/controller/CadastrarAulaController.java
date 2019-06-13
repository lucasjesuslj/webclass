package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Aula;
import entity.Curso;
import exception.CursoDAOException;

@WebServlet("/view/cadastrarAula")
public class CadastrarAulaController extends HttpServlet {

	private static final long serialVersionUID = 7403596064988111621L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) {

		AulaController aulaController = new AulaController();

		String descricao = req.getParameter("descricao");
		int codCurso = Integer.parseInt(req.getParameter("curso"));

		Aula aula = new Aula();
		Curso curso = new Curso();

		curso.setCodCurso(codCurso);

		aula.setDescricao(descricao);
		aula.setCurso(curso);

		try {
			aulaController.insertAula(aula);
			req.setAttribute("mensagem", "Aula cadastrada com sucesso.");
			try {
				req.getRequestDispatcher("./CadastrarAula.jsp").forward(req, res);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} catch (CursoDAOException e) {
			try {
				req.setAttribute("erro", e.getMessage());
				req.getRequestDispatcher("./CadastrarAula.jsp").forward(req, res);
			} catch (ServletException | IOException ie) {
				ie.printStackTrace();
			}
		}

	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) {

		try {
			res.sendRedirect("./CadastrarAula.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
