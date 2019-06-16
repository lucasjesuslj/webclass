package dao;

import java.util.List;
import entity.AtividadeAtiva;
import entity.AulaAtiva;
import exception.AtividadeAtivaDAOException;

public interface AtividadeAtivaDAO {

	void insertAtividadeAtiva(AtividadeAtiva atividadeAtiva) throws AtividadeAtivaDAOException;
	
	List<AtividadeAtiva> getByAula(AulaAtiva aulaAtiva) throws AtividadeAtivaDAOException;
	
	void updateStatus(AtividadeAtiva atividadeAtiva, String status) throws AtividadeAtivaDAOException;
	
}
