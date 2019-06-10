package controller;

import java.util.List;
import dao.ProfessorDAO;
import dao.ProfessorDAOImpl;
import entity.Professor;
import exception.ProfessorDAOException;

public class ProfessorController {

	private ProfessorDAO dao = new ProfessorDAOImpl();

	// insere Professor
	public void insertProfessor(Professor professor) {

		try {
			dao.insertProfessor(professor);
		} catch (ProfessorDAOException e) {
			throw new ProfessorDAOException("E-mail j� cadastrado no sistema");
		}

	}
	
	// verifica se um Professor existe passando o Email e a Senha
	public Professor getByEmailAndSenha(String email, String senha) {
		Professor professor = null;
		
		professor = dao.getByEmailAndSenha(email, senha);
		
		if (professor == null) {
			throw new ProfessorDAOException("Email e/ou senha inv�lidos");
		} 
		
		return professor;
	}

	// select de Professor pelo ID
	public Professor getById(int id) {

		Professor professor = null;

		try {
			professor = dao.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return professor;
	}

	// lista todos os Professores
	public List<Professor> getAll() {

		List<Professor> professores = null;

		try {
			professores = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return professores;

	}

}

