package controller;

import java.util.List;
import dao.CoordenadorDAO;
import dao.CoordenadorDAOImpl;
import entity.Coordenador;
import exception.CoordenadorDAOException;

public class CoordenadorController {

	private CoordenadorDAO dao = new CoordenadorDAOImpl();

	// insere Coordenador
	public void insertCoordenador(Coordenador coordenador) {

		try {
			dao.insertCoordenador(coordenador);
		} catch (CoordenadorDAOException e) {
			throw new CoordenadorDAOException("E-mail já cadastrado no sistema");
		}

	}

	// verifica se um Coordenador existe passando o Email e a Senha
	public Coordenador getByEmailAndSenha(String email, String senha) {
		Coordenador coordenador = null;
		
		coordenador = dao.getByEmailAndSenha(email, senha);

		if (coordenador == null) {
			throw new CoordenadorDAOException("Email e/ou senha inválidos");
		}
		
		return coordenador;
	}

	// select de Coordenador pelo ID
	public Coordenador getById(int id) {

		Coordenador coordenador = null;

		try {
			coordenador = dao.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return coordenador;
	}

	// lista todos os Coordenadores
	public List<Coordenador> getAll() {

		List<Coordenador> coordenadores = null;

		try {
			coordenadores = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return coordenadores;

	}

}

