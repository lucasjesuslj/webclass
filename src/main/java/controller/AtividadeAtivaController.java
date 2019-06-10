package controller;

import java.util.ArrayList;
import java.util.List;
import dao.AtividadeAtivaDAO;
import dao.AtividadeAtivaDAOImpl;
import entity.AtividadeAtiva;
import entity.AulaAtiva;

public class AtividadeAtivaController {

	public AtividadeAtivaDAO dao = new AtividadeAtivaDAOImpl();

	// insere novas Atividades
	public void insertAtividadeAtiva(AtividadeAtiva atividadeAtiva) {

		try {
			dao.insertAtividadeAtiva(atividadeAtiva);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// select das Aulas Ativas do Aluno
	public List<AtividadeAtiva> getByAula(AulaAtiva aulaAtiva) {

		List<AtividadeAtiva> atividadesAtivas = new ArrayList<AtividadeAtiva>();

		try {
			atividadesAtivas = dao.getByAula(aulaAtiva);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return atividadesAtivas;

	}

	// muda o Status de uma AtividadeAtiva
	public void updateStatus(AtividadeAtiva atividadeAtiva, String status) {

		try {
			dao.updateStatus(atividadeAtiva, status);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
