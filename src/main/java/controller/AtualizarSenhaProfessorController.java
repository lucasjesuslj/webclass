package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.Professor;
import exception.AlunoDAOException;

@WebServlet("/view/atualizarSenhaProfessor")
public class AtualizarSenhaProfessorController extends HttpServlet {

	private static final long serialVersionUID = 8343402354841149020L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) {

		HttpSession sessao = req.getSession(true);
		Professor professor = (Professor) sessao.getAttribute("Professor");

		ProfessorController professorController = new ProfessorController();

		int codProfessor = professor.getCodProfessor();
		String email = req.getParameter("email");
		String senhaAtual = req.getParameter("senhaAtual");
		String senhaNova = req.getParameter("senhaNova");
		
		professor = professorController.getById(codProfessor);
		professor.setCodProfessor(codProfessor);
		
		if (senhaAtual.equals(professor.getSenha())) {
			
			try {
				professorController.updateEmail(professor, email);
				professorController.updateSenha(professor, senhaNova);
				req.setAttribute("mensagem", "E-mail e senha atualizados com sucesso");
			} catch (AlunoDAOException e) {

				req.setAttribute("erro", e.getMessage());

			} finally {
				
				try {
					req.getRequestDispatcher("./PerfilProfessor.jsp").forward(req, res);
				} catch (ServletException | IOException ie) {
					ie.printStackTrace();
				}
				
			}
			
		} else {
			
			req.setAttribute("erro", "A Senha Atual digitada está incorreta");
			
			try {
				req.getRequestDispatcher("./PerfilProfessor.jsp").forward(req, res);
			} catch (ServletException | IOException ie) {
				ie.printStackTrace();
			}
			
		}

	
	}

}

