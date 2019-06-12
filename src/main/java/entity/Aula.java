package entity;

import java.util.Date;

public class Aula {

	private int codAula;
	private String descricao;
	private Date dataCriacao;
	private Curso curso;

	public int getCodAula() {
		return codAula;
	}

	public void setCodAula(int codAula) {
		this.codAula = codAula;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataCriaco() {
		return dataCriacao;
	}

	public void setDataCriaco(Date dataCriaco) {
		this.dataCriacao = dataCriaco;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
