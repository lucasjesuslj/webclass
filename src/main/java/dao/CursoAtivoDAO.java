package dao;

import java.util.List;
import entity.Aluno;
import entity.Curso;
import entity.CursoAtivo;
import exception.CursoAtivoDAOException;

public interface CursoAtivoDAO {

	void insertCursoAtivo (CursoAtivo cursoAtivo) throws CursoAtivoDAOException;
	
	List<CursoAtivo> getAllByAluno(Aluno aluno) throws CursoAtivoDAOException;
	
	CursoAtivo getByAlunoAndCurso(Curso curso, Aluno aluno) throws CursoAtivoDAOException;
}
