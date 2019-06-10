package dao;

import java.util.List;

import entity.Coordenador;

public interface CoordenadorDAO {

	void insertCoordenador(Coordenador coordenador);

	Coordenador getByEmailAndSenha(String email, String senha);

	Coordenador getById(int id);

	List<Coordenador> getAll();

}
