package entity;

//associativa entre Curso e Aluno (os Cursos que um Aluno está cursando)
public class CursoAtivo {
	
	private Aluno aluno;
	private Curso curso;
	private String estatus;
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

}
