package dao;

import java.util.List;
import entity.Aula;
import entity.Curso;
import entity.Professor;
import exception.AulaDAOException;

public interface AulaDAO {

	void insertAula(Aula aula);

	Aula getById(int id) throws AulaDAOException;
	
	List<Aula> getByCurso(Curso curso);
	
	List<Aula> getByProfessor(Professor professor);
	
	int getCountByCurso(Curso curso);
			
}
