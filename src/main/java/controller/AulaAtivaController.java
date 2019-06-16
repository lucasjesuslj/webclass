package controller;

import java.util.List;

import dao.AulaAtivaDAO;
import dao.AulaAtivaDAOImpl;
import entity.Aula;
import entity.AulaAtiva;
import entity.CursoAtivo;

public class AulaAtivaController {

	public AulaAtivaDAO dao = new AulaAtivaDAOImpl();

	public void insertAulaAtiva(AulaAtiva aulaAtiva) {

		try {
			dao.insertAulaAtiva(aulaAtiva);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public AulaAtiva getByAlunoCursoAndAula(CursoAtivo cursoAtivo, Aula aula) {

		AulaAtiva aulaAtiva = new AulaAtiva();

		try {
			aulaAtiva = dao.getByAlunoCursoAndAula(cursoAtivo, aula);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return aulaAtiva;

	}

	// Listar Aulas Ativas de um Curso Ativo (Aulas disponiveis de um Curso que o
	// Aluno está matriculado)
	public List<AulaAtiva> getByAlunoAndCurso(CursoAtivo cursoAtivo) {

		List<AulaAtiva> aulasAtivas = null;

		try {
			aulasAtivas = dao.getByAlunoAndCurso(cursoAtivo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return aulasAtivas;

	}

	// Atualizar status da Aula Ativa
	public void updateStatus(AulaAtiva aulaAtiva, String status) {

		try {
			dao.updateStatus(aulaAtiva, status);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Quantidade total de Aulas Ativas de um CursoAtivo
	public int getCountByCursoAtivo(CursoAtivo cursoAtivo) {

		int quantidade = 0;

		try {
			return dao.getCountByCursoAtivo(cursoAtivo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return quantidade;

	}

}
