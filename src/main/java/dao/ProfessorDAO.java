package dao;

import java.util.List;
import entity.Professor;
import exception.ProfessorDAOException;

public interface ProfessorDAO {

	void insertProfessor(Professor professor) throws ProfessorDAOException;

	Professor getByEmailAndSenha(String email, String senha) throws ProfessorDAOException;

	Professor getById(int id) throws ProfessorDAOException;

	List<Professor> getAll() throws ProfessorDAOException;

}