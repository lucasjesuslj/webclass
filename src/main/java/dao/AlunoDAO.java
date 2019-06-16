package dao;

import java.util.List;

import entity.Aluno;
import exception.AlunoDAOException;

public interface AlunoDAO {

	void insertAluno(Aluno aluno) throws AlunoDAOException;

	Aluno getByEmailAndSenha(String email, String senha) throws AlunoDAOException;

	Aluno getById(int id) throws AlunoDAOException;

	void updateEmail(Aluno aluno, String email) throws AlunoDAOException;

	void updateSenha(Aluno aluno, String senha) throws AlunoDAOException;

	List<Aluno> getAll() throws AlunoDAOException;

}
