package dao;

import java.util.List;
import entity.Aula;
import entity.AulaAtiva;
import entity.CursoAtivo;
import exception.AulaAtivaDAOException;

public interface AulaAtivaDAO {

	void insertAulaAtiva(AulaAtiva aulaAtiva) throws AulaAtivaDAOException;

	AulaAtiva getByAlunoCursoAndAula(CursoAtivo cursoAtivo, Aula aula) throws AulaAtivaDAOException;

	List<AulaAtiva> getByAlunoAndCurso(CursoAtivo cursoAtivo) throws AulaAtivaDAOException;

	void updateStatus(AulaAtiva aulaAtiva, String status) throws AulaAtivaDAOException;

	int getCountByCursoAtivo(CursoAtivo cursoAtivo) throws AulaAtivaDAOException;
	
}
