package dao;

import java.util.List;
import entity.Aula;
import entity.AulaAtiva;
import entity.CursoAtivo;

public interface AulaAtivaDAO {

	void insertAulaAtiva(AulaAtiva aulaAtiva);
	
	AulaAtiva getByAlunoCursoAndAula(CursoAtivo cursoAtivo, Aula aula);
	
	List<AulaAtiva> getByAlunoAndCurso(CursoAtivo cursoAtivo);
	
	void updateStatus(AulaAtiva aulaAtiva, String status);
	
	int getCountByCursoAtivo(CursoAtivo cursoAtivo);
}
