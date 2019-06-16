package dao;

import java.util.List;
import entity.Atividade;
import entity.Aula;
import exception.AtividadeDAOException;

public interface AtividadeDAO {

	void insertAtividade(Atividade atividade) throws AtividadeDAOException;

	List<Atividade> getByAula(Aula aula) throws AtividadeDAOException;
		
	Atividade getById(int id) throws AtividadeDAOException;
	
}
