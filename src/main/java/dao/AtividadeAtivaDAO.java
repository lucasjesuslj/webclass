package dao;

import java.util.List;
import entity.AtividadeAtiva;
import entity.AulaAtiva;

public interface AtividadeAtivaDAO {

	void insertAtividadeAtiva(AtividadeAtiva atividadeAtiva);
	
	List<AtividadeAtiva> getByAula(AulaAtiva aulaAtiva);
	
	void updateStatus(AtividadeAtiva atividadeAtiva, String status);
	
}
