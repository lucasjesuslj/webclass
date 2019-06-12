package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Aluno;
import entity.Coordenador;
import entity.Professor;
import exception.AlunoDAOException;
import exception.CoordenadorDAOException;
import exception.ProfessorDAOException;

@WebServlet("/view/cadastrarUsuario")
public class CadastrarController extends HttpServlet{

	private static final long serialVersionUID = -4472195635047879811L;

	// cadastra o Aluno passando o Nome, Email e Senha
	// dependendo do login do usuario
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
				
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		int usuario = Integer.parseInt(req.getParameter("usuario"));
		
		if (usuario == 1){ 
			
			AlunoController alunoController = new AlunoController();
			
			Aluno aluno = new Aluno();
			aluno.setNome(nome);
			aluno.setEmail(email);
			aluno.setSenha(senha);
			
			try {
				alunoController.insertAluno(aluno);
				req.setAttribute("mensagem", "Cadastro efetuado com sucesso");
			} catch (AlunoDAOException e) {
				req.setAttribute("erro", e.getMessage());
			} finally {
				try {
					req.getRequestDispatcher("./Login.jsp").forward(req, res);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}
			
		} else if (usuario == 2) {
		
			ProfessorController professorController = new ProfessorController();
			
			Professor professor = new Professor();
			
			professor.setNome(nome);
			professor.setEmail(email);
			professor.setSenha(senha);
			
			try {
				professorController.insertProfessor(professor);
				req.setAttribute("mensagem", "Cadastro efetuado com sucesso");
			} catch (ProfessorDAOException e) {
				req.setAttribute("erro", e.getMessage());
			} finally {
				try {
					req.getRequestDispatcher("./Login.jsp").forward(req, res);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}
			
		} else if (usuario == 3) {
		
			CoordenadorController coordenadorController = new CoordenadorController();
			
			Coordenador coordenador = new Coordenador();
			
			coordenador.setNome(nome);
			coordenador.setEmail(email);
			coordenador.setSenha(senha);
						
			try {
				coordenadorController.insertCoordenador(coordenador);
				req.setAttribute("mensagem", "Cadastro efetuado com sucesso");
			} catch (CoordenadorDAOException e) {
				req.setAttribute("erro", e.getMessage());
			} finally {
				try {
					req.getRequestDispatcher("./Login.jsp").forward(req, res);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}
		}		
		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			res.sendRedirect("./Login.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
