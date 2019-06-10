package dao;

import java.util.List;

import entity.Aluno;
import exception.AlunoDAOException;

public interface AlunoDAO {

	void insertAluno(Aluno aluno) throws AlunoDAOException;

	Aluno getByEmailAndSenha(String email, String senha) throws AlunoDAOException;

	Aluno getById(int id);

	void updateEmail(Aluno aluno, String email);

	void updateSenha(Aluno aluno, String senha);

	List<Aluno> getAll();

}
