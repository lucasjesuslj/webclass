package entity;

//associativa entre CursoAtivo e Aula (as Aulas Ativas de um Curso Ativo)
public class AulaAtiva {

	private CursoAtivo cursoAtivo;
	private Aula aula;
	private String estatus;

	public CursoAtivo getCursoAtivo() {
		return cursoAtivo;
	}

	public void setCursoAtivo(CursoAtivo cursoAtivo) {
		this.cursoAtivo = cursoAtivo;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

}
