package entity;

//agregação de Atividade, contendo os arquivos que uma aula contém
public class ConteudoAtividade {

	private byte[] conteudo;
	private Atividade atividade;

	public byte[] getConteudo() {
		return conteudo;
	}

	public void setConteudo(byte[] conteudo) {
		this.conteudo = conteudo;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

}
