package dao;

import java.util.List;

import entity.Aula;
import entity.Curso;

public interface AulaDAO {

	void insertAula(Aula aula);

	List<Aula> getByCurso(Curso curso);
	
	int getCountByCurso(Curso curso);
			
}
