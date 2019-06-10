package controller;

import java.util.List;

import dao.AtividadeDAO;
import dao.AtividadeDAOImpl;
import entity.Atividade;
import entity.Aula;

public class AtividadeController {
	
	public AtividadeDAO dao = new AtividadeDAOImpl();

	// passa uma atividade para ser inserida
	public void insertAtividade(Atividade atividade) {

		try {
			dao.insertAtividade(atividade);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// pesquisa de Atividades por Aula, colocando numa lista
	public List<Atividade> getByAula(Aula aula) {

		List<Atividade> atividades = null;

		try {
			atividades = dao.getByAula(aula);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return atividades;

	}

}
