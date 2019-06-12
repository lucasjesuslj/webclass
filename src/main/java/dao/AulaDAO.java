package dao;

import java.util.List;
import entity.Aula;
import entity.Curso;
import exception.AulaDAOException;

public interface AulaDAO {

	void insertAula(Aula aula);

	Aula getById(int id) throws AulaDAOException;
	
	List<Aula> getByCurso(Curso curso);
	
	int getCountByCurso(Curso curso);
			
}
