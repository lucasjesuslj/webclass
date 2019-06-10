package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Categoria;
import entity.Coordenador;
import entity.Curso;
import entity.Professor;
import exception.CursoDAOException;

@WebServlet("/view/cadastrarCurso")
public class CadastrarCursoController extends HttpServlet {

	private static final long serialVersionUID = 5978818145990470153L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) {

		CursoController cursoController = new CursoController();
		
		// Pega a entidade do Coordenador da sessão
		Coordenador coordenador = (Coordenador) req.getSession().getAttribute("Coordenador");

		// Parâmetros do form
		String nomeCurso = req.getParameter("nomeCurso");
		String descricao = req.getParameter("descricao");
		int duracao = Integer.parseInt(req.getParameter("duracao"));
		int codCategoria = Integer.parseInt(req.getParameter("categoria"));
		int codProfessor = Integer.parseInt(req.getParameter("professor"));

		//Criação de objeto Curso
		Curso curso = new Curso();
		Categoria categoria = new Categoria();
		Professor professor = new Professor();

		professor.setCodProfessor(codProfessor);
		categoria.setCodCategoria(codCategoria);

		curso.setNomeCurso(nomeCurso);
		curso.setDescricao(descricao);
		curso.setDuracao(duracao);
		curso.setEstatus("D");
		curso.setCategoria(categoria);
		curso.setProfessor(professor);
		curso.setCoordenador(coordenador);

		try {
			cursoController.inserirCurso(curso);
			req.setAttribute("mensagem", "Curso cadastrado com sucesso.");
			try {
				req.getRequestDispatcher("./CadastrarCurso.jsp").forward(req, res);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} catch (CursoDAOException e) {
			try {
				req.setAttribute("erro", e.getMessage());
				req.getRequestDispatcher("./CadastrarCurso.jsp").forward(req, res);
			} catch (ServletException | IOException ie) {
				ie.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			res.sendRedirect("./CadastrarCurso.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
