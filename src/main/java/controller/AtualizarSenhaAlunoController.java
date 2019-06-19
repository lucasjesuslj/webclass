package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.Aluno;
import exception.AlunoDAOException;

@WebServlet("/view/atualizarSenhaAluno")
public class AtualizarSenhaAlunoController extends HttpServlet {

	private static final long serialVersionUID = 2536190487238153323L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) {

		HttpSession sessao = req.getSession(true);
		Aluno aluno = (Aluno) sessao.getAttribute("Aluno");

		AlunoController alunoController = new AlunoController();

		int codAluno = aluno.getCodAluno();
		String email = req.getParameter("email");
		String senhaAtual = req.getParameter("senhaAtual");
		String senhaNova = req.getParameter("senhaNova");
		
		aluno = alunoController.getById(codAluno);
		aluno.setCodAluno(codAluno);
		
		if (senhaAtual.equals(aluno.getSenha())) {
			
			try {
				alunoController.updateEmail(aluno, email);
				alunoController.updateSenha(aluno, senhaNova);
				req.setAttribute("mensagem", "E-mail e senha atualizados com sucesso");
			} catch (AlunoDAOException e) {

				req.setAttribute("erro", e.getMessage());

			} finally {
				
				try {
					req.getRequestDispatcher("./PerfilAluno.jsp").forward(req, res);
				} catch (ServletException | IOException ie) {
					ie.printStackTrace();
				}
				
			}
			
		} else {
			
			req.setAttribute("erro", "A Senha Atual digitada está incorreta");
			
			try {
				req.getRequestDispatcher("./PerfilAluno.jsp").forward(req, res);
			} catch (ServletException | IOException ie) {
				ie.printStackTrace();
			}
			
		}

	
	}

}
