package dao;

import java.util.List;
import entity.Curso;
import entity.Professor;
import exception.CursoDAOException;

public interface CursoDAO {

	//insert de Curso
	void insertCurso(Curso coordenador) throws CursoDAOException;

	//Recupera as informações do Curso pelo codCurso
	Curso getById(int id) throws CursoDAOException;

	//Recupera todos os Cursos cadastrados com Estatus = 'A'
	List<Curso> getAll() throws CursoDAOException;
	
	//HD - Habilitados e Desabilitados
	List<Curso> getAllHD() throws CursoDAOException;
	
	List<Curso> getAllByProfessor(Professor professor) throws CursoDAOException;
	
	//Atualiza o Estatus do Curso
	void updateEstatus(Curso curso, String estatus);
	
}

