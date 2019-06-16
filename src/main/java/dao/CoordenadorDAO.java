package dao;

import java.util.List;
import entity.Coordenador;
import exception.CoordenadorDAOException;

public interface CoordenadorDAO {

	void insertCoordenador(Coordenador coordenador) throws CoordenadorDAOException;

	Coordenador getByEmailAndSenha(String email, String senha) throws CoordenadorDAOException;

	Coordenador getById(int id) throws CoordenadorDAOException;

	List<Coordenador> getAll() throws CoordenadorDAOException;

}
