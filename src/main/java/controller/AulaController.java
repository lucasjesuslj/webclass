package controller;

import java.util.List;

import dao.AulaDAO;
import dao.AulaDAOImpl;
import entity.Aula;
import entity.Curso;
import entity.Professor;
import exception.AulaDAOException;

public class AulaController {

	public AulaDAO dao = new AulaDAOImpl();

	// insere Aulas
	public void insertAula(Aula aula) {

		try {
			dao.insertAula(aula);
		} catch (AulaDAOException e) {
			throw new AulaDAOException("Não cadastrou");
		}

	}

	// lista todas as AulasAtivas de um CursoAtivo
	public List<Aula> getByCurso(Curso curso) {

		List<Aula> aulas = null;

		try {
			aulas = dao.getByCurso(curso);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return aulas;

	}

	// Quantidade total de Aulas de um Curso
	public int getCountByCurso(Curso curso){
	
		int quantidade = 0;
		
		try {
			return dao.getCountByCurso(curso);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return quantidade;
		
	}
	
	public Aula getById (int id) {
		
		Aula aula = null;

		aula = dao.getById(id);
		
		if (aula == null) {
			
			throw new AulaDAOException("Aula não encontrada");
			
		}

		return aula;
		
	}
	
	public List<Aula> getByProfessor(Professor professor){
		
		List<Aula> aulas = null;

		try {
			aulas = dao.getByProfessor(professor);
		} catch (AulaDAOException e) {
			e.printStackTrace();
		}

		return aulas;
		
	}

}
