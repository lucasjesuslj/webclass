package controller;

import java.util.List;
import dao.AlunoDAO;
import dao.AlunoDAOImpl;
import entity.Aluno;
import exception.AlunoDAOException;

public class AlunoController {

	private AlunoDAO dao = new AlunoDAOImpl();

	// insert de Aluno passando Aluno
	public void insertAluno(Aluno aluno) {

		try {
			dao.insertAluno(aluno);
		} catch (AlunoDAOException e) {
			throw new AlunoDAOException("E-mail já cadastrado no sistema");
		}

	}
	
	// select de Aluno pelo Email e Senha
	public Aluno getByEmailAndSenha(String email, String senha) throws AlunoDAOException {
		Aluno aluno = null;

		aluno = dao.getByEmailAndSenha(email, senha);

		if (aluno == null) {
			throw new AlunoDAOException("Email e/ou senha inválidos");
		} 
			
		return aluno;
	}

	// select de Aluno pelo Id
	public Aluno getById(int id) {

		Aluno aluno = null;

		try {
			aluno = dao.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return aluno;
	}

	// Atualizar Email do Aluno
	public void updateEmail(Aluno aluno, String email) {

		try {
			dao.updateEmail(aluno, email);
		} catch (AlunoDAOException e) {
			throw new AlunoDAOException("Tamanho máximo pro campo e-mail excedido");
		}

	}

	// Atualizar Senha do Aluno
	public void updateSenha(Aluno aluno, String senha) {

		try {
			dao.updateSenha(aluno, senha);
		} catch (AlunoDAOException e) {
			throw new AlunoDAOException("Tamanho máximo pro campo senha excedido");
		}

	}

	// listar todos os Alunos
	public List<Aluno> getAll() {

		List<Aluno> alunos = null;

		try {
			alunos = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return alunos;

	}

}
