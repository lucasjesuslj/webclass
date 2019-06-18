package controller;

import java.util.ArrayList;
import java.util.List;
import dao.AtividadeAtivaDAO;
import dao.AtividadeAtivaDAOImpl;
import entity.Atividade;
import entity.AtividadeAtiva;
import entity.AulaAtiva;
import exception.AtividadeAtivaDAOException;

public class AtividadeAtivaController {

	public AtividadeAtivaDAO dao = new AtividadeAtivaDAOImpl();

	// insere novas Atividades
	public void insertAtividadeAtiva(AtividadeAtiva atividadeAtiva) {

		try {
			dao.insertAtividadeAtiva(atividadeAtiva);
		} catch (AtividadeAtivaDAOException e) {
			throw new AtividadeAtivaDAOException("Erro ao cadastrar Aluno no Curso");
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

	public AtividadeAtiva getByAulaAtivaAndAtividade(AulaAtiva aulaAtiva, Atividade atividade) {
		
		AtividadeAtiva atividadeAtiva = null;
		
		try {
			atividadeAtiva = dao.getByAulaAtivaAndAtividade(aulaAtiva, atividade);
		} catch (AtividadeAtivaDAOException e) {
			e.printStackTrace();
		}
		
		return atividadeAtiva;
		
	}
}
