package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.Aluno;
import entity.Coordenador;
import entity.Professor;
import exception.AlunoDAOException;
import exception.CoordenadorDAOException;

@WebServlet("/view/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = -506825035538407676L;

	// passa o Email e a Senha do Usuario e verifica se tem algum cadastrado que
	// bate
	// dependendo do login (Aluno, Professor, Coordenador)
	public void doPost(HttpServletRequest req, HttpServletResponse res) {

		int usuario = Integer.parseInt(req.getParameter("usuario"));

		String email = req.getParameter("email");
		String senha = req.getParameter("senha");

		if (usuario == 1) {

			AlunoController alunoController = new AlunoController();

			Aluno aluno = null;

			//Verifica se retorna algum objeto Aluno ou se lança uma exceção
			try {
				aluno = alunoController.getByEmailAndSenha(email, senha);
			} catch (AlunoDAOException e) {
				try {
					req.setAttribute("erro", e.getMessage());
					req.getRequestDispatcher("./Login.jsp").forward(req, res);
				} catch (ServletException | IOException ie) {
					ie.printStackTrace();
				}
			}

			if (aluno != null) {

				try {

					// Cria uma nova sessão
					HttpSession sessao = req.getSession(true);

					// Tempo da Sessão
					sessao.setMaxInactiveInterval(20 * 60);

					// Passa a entidade Aluno pra sessão
					sessao.setAttribute("Aluno", aluno);

					res.sendRedirect("./AlunoHome.jsp");

				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		}

		else if (usuario == 2) {

			ProfessorController professorController = new ProfessorController();

			Professor professor = new Professor();

			//Verifica se retorna algum objeto Professor ou se lança uma exceção
			try {
				professor = professorController.getByEmailAndSenha(email, senha);
			} catch (AlunoDAOException e) {
				try {
					req.setAttribute("erro", e.getMessage());
					req.getRequestDispatcher("./Login.jsp").forward(req, res);
				} catch (ServletException | IOException ie) {
					ie.printStackTrace();
				}
			}
			
			if (professor != null) {

				try {

					// Cria uma nova sessão
					HttpSession sessao = req.getSession(true);

					// Tempo da Sessão
					sessao.setMaxInactiveInterval(20 * 60);

					// Passa a entidade Professor pra sessão
					sessao.setAttribute("Professor", professor);

					res.sendRedirect("./ProfessorHome.jsp");

				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		else if (usuario == 3) {

			CoordenadorController coordenadorController = new CoordenadorController();

			Coordenador coordenador = new Coordenador();

			//Verifica se retorna algum objeto Coordenador ou se lança uma exceção
			try {
				coordenador = coordenadorController.getByEmailAndSenha(email, senha);
			} catch (CoordenadorDAOException e) {
				try {
					req.setAttribute("erro", e.getMessage());
					req.getRequestDispatcher("./Login.jsp").forward(req, res);
				} catch (ServletException | IOException ie) {
					ie.printStackTrace();
				}
			}
			
			if (coordenador != null) {

				try {

					// Cria uma nova sessão
					HttpSession sessao = req.getSession(true);

					// Tempo da Sessão
					sessao.setMaxInactiveInterval(20 * 60);

					// Passa a entidade Coordenador pra sessão
					sessao.setAttribute("Coordenador", coordenador);

					res.sendRedirect("./CadastrarCurso.jsp");

				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}
	
	//Se a url "http://localhost:8080/WebClass/view/login" é acionada, retorna pra a página de Login.jsp
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			res.sendRedirect("./Login.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
