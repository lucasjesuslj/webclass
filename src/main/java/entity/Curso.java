package entity;

import java.util.Date;

public class Curso {

	private int codCurso;
	private String nomeCurso;
	private String descricao;
	private int duracao;
	private String estatus;
	private Date dataCriacao;
	private Date dataAlteracao;
	private Coordenador coordenador;
	private Professor professor;
	private Categoria categoria;

	public Curso(String nomeCurso, String descricao, int duracao, String estatus, Date dataCriacao, Date dataAlteracao,
			Coordenador coordenador, Professor professor, Categoria categoria) {
		this.nomeCurso = nomeCurso;
		this.descricao = descricao;
		this.duracao = duracao;
		this.estatus = estatus;
		this.dataCriacao = dataCriacao;
		this.dataAlteracao = dataAlteracao;
		this.coordenador = coordenador;
		this.professor = professor;
		this.categoria = categoria;
	}
	
	public Curso() {}

	public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public Coordenador getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Coordenador coordenador) {
		this.coordenador = coordenador;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
