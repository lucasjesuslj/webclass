package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Atividade;
import entity.Aula;
import entity.Coordenador;
import exception.CursoDAOException;

@WebServlet("/view/cadastrarAtividade")
public class CadastrarAtividadeController extends HttpServlet {

	private static final long serialVersionUID = -5967593159763053200L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) {

		AtividadeController atividadeController = new AtividadeController();

		String nome = req.getParameter("nomeAtividade");
		String descricao = req.getParameter("descricao");
		String resposta = req.getParameter("resposta");
		int codAula = Integer.parseInt(req.getParameter("codAula"));

		Atividade atividade = new Atividade();
		Aula aula = new Aula();

		aula.setCodAula(codAula);
		atividade.setNome(nome);
		atividade.setDescricao(descricao);
		atividade.setResposta(resposta);
		atividade.setAula(aula);

		try {
			atividadeController.insertAtividade(atividade);
			req.setAttribute("mensagem", "Atividade cadastrada com sucesso.");
			try {
				req.getRequestDispatcher("./CadastrarAtividade.jsp").forward(req, res);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} catch (CursoDAOException e) {
			try {
				req.setAttribute("erro", e.getMessage());
				req.getRequestDispatcher("./CadastrarAtividade.jsp").forward(req, res);
			} catch (ServletException | IOException ie) {
				ie.printStackTrace();
			}
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) {

		try {
			res.sendRedirect("./CadastrarAtividade.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
