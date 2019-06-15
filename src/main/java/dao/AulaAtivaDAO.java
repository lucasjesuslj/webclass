package dao;

import java.util.List;
import entity.Aula;
import entity.AulaAtiva;
import entity.CursoAtivo;
import exception.AulaAtivaDAOException;

public interface AulaAtivaDAO {

	void insertAulaAtiva(AulaAtiva aulaAtiva);

	AulaAtiva getByAlunoCursoAndAula(CursoAtivo cursoAtivo, Aula aula);

	List<AulaAtiva> getByAlunoAndCurso(CursoAtivo cursoAtivo);

	void updateStatus(AulaAtiva aulaAtiva, String status) throws AulaAtivaDAOException;

	int getCountByCursoAtivo(CursoAtivo cursoAtivo);
	
}
