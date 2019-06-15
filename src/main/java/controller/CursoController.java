package controller;import java.util.List;import dao.CursoDAO;import dao.CursoDAOImpl;import entity.Curso;import entity.Professor;import exception.CursoDAOException;public class CursoController {	public CursoDAO dao = new CursoDAOImpl();	// insere Curso	public void inserirCurso(Curso curso) {		try {			dao.insertCurso(curso);		} catch (CursoDAOException e) {			throw new CursoDAOException("J� existe um Curso cadastrado com nome \""+curso.getNomeCurso()+"\"");		}	}	// select de Curso pelo ID	public Curso getById(int id) {		Curso curso = null;		try {			curso = dao.getById(id);		} catch (Exception e) {			e.printStackTrace();		}		return curso;	}	// lista todos os Cursos	public List<Curso> getAll() {		List<Curso> cursos = null;		try {			cursos = dao.getAll();		} catch (CursoDAOException e) {			e.printStackTrace();		}		return cursos;	}	// lista todos os Cursos	public List<Curso> getAllHD() {		List<Curso> cursos = null;		try {			cursos = dao.getAllHD();		} catch (CursoDAOException e) {			e.printStackTrace();		}		return cursos;	}	public List<Curso> getAllByProfessor(Professor professor) {				List<Curso> cursos = null;		try {			cursos = dao.getAllByProfessor(professor);		} catch (CursoDAOException e) {			throw new CursoDAOException("Erro ao carregar lista de Cursos");		}		return cursos;			}	public void updateEstatus(Curso curso, String estatus) {		try {			dao.updateEstatus(curso, estatus);		} catch (CursoDAOException e) {			throw new CursoDAOException("Erro na atualiza��o de Status do Curso");		}	}}