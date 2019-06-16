package dao;

import java.util.List;
import entity.Aula;
import entity.Curso;
import entity.Professor;
import exception.AulaDAOException;

public interface AulaDAO {

	void insertAula(Aula aula) throws AulaDAOException;

	Aula getById(int id) throws AulaDAOException;
	
	List<Aula> getByCurso(Curso curso) throws AulaDAOException;
	
	List<Aula> getByProfessor(Professor professor) throws AulaDAOException;
	
	int getCountByCurso(Curso curso) throws AulaDAOException;
			
}
