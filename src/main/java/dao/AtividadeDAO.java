package dao;

import java.util.List;
import entity.Atividade;
import entity.Aula;

public interface AtividadeDAO {

	void insertAtividade(Atividade atividade);

	List<Atividade> getByAula(Aula aula);
	
	Atividade getById(int id);
	
}
