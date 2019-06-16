package entity;

//associativa entre AulaAtiva e Atividade (As Atividades ativas de uma Aula Ativa)
public class AtividadeAtiva {

	private AulaAtiva aulaAtiva;
	private Atividade atividade;
	private String estatus;
	private String comentario;

	public AulaAtiva getAulaAtiva() {
		return aulaAtiva;
	}

	public void setAulaAtiva(AulaAtiva aulaAtiva) {
		this.aulaAtiva = aulaAtiva;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
