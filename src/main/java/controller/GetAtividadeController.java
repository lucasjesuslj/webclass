package controller;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.Atividade;

@WebServlet("/view/atividadeAtiva")
public class GetAtividadeController extends HttpServlet {

	private static final long serialVersionUID = -6507061128245099732L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) {

		AtividadeController atividadeController = new AtividadeController();
		
		int codAtividade = Integer.parseInt(req.getParameter("codAtividade"));
		HttpSession sessao = req.getSession(true);

		Atividade atividade = new Atividade();

		atividade = atividadeController.getById(codAtividade);
		
		atividade.setCodAtividade(codAtividade);
		
		sessao.setAttribute("Atividade", atividade);

		try {
			res.sendRedirect("./AtividadeAtiva.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

