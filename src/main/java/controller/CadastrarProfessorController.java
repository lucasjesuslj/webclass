package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Professor;
import exception.ProfessorDAOException;

@WebServlet("/view/cadastrarProfessor")
public class CadastrarProfessorController extends HttpServlet{

	private static final long serialVersionUID = 1716888804981052933L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		
		ProfessorController professorController = new ProfessorController();
		
		String nomeProfessor = req.getParameter("nomeProfessor");
		String emailProfessor = req.getParameter("emailProfessor");
		String senhaProfessor = req.getParameter("senhaProfessor");
		
		Professor professor= new Professor();
		
		professor.setNome(nomeProfessor);
		professor.setEmail(emailProfessor);
		professor.setSenha(senhaProfessor);
		
		try {
			professorController.insertProfessor(professor);
			req.setAttribute("mensagem", "Professor Cadastrado com Sucesso");
			try {
				req.getRequestDispatcher("./CadastrarProfessor.jsp").forward(req, res);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} catch (ProfessorDAOException e) {
			try {
				req.setAttribute("erro", e.getMessage());
				req.getRequestDispatcher("./CadastrarProfessor.jsp").forward(req, res);
			} catch (ServletException | IOException ie) {
				ie.printStackTrace();
			}
		}
		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			res.sendRedirect("./CadastrarProfessor.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

