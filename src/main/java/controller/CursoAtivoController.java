package controller;

import java.util.List;
import dao.CursoAtivoDAO;
import dao.CursoAtivoDAOImpl;
import entity.Aluno;
import entity.Curso;
import entity.CursoAtivo;

public class CursoAtivoController {

	public CursoAtivoDAO dao = new CursoAtivoDAOImpl();
		
	public void insertCursoAtivo(CursoAtivo cursoAtivo) {
	
		try {
			dao.insertCursoAtivo(cursoAtivo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//lista todos os CursosAtivos por Aluno
	public List<CursoAtivo> getAllByAluno(Aluno aluno){
		
		List<CursoAtivo> cursosAtivos = null;
		
		try {
			cursosAtivos = dao.getAllByAluno(aluno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cursosAtivos;
		
	}
	
	//Retorna um CursoAtivo se o Aluno ainda não estiver matriculado no Curso
	public CursoAtivo getByAlunoAndCurso(Curso curso, Aluno aluno) {

		return dao.getByAlunoAndCurso(curso, aluno);
		
	}
}
