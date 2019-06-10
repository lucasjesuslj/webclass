package entity;

//ela serve para gravar os conteudos upados por cada aluno em determinada atividade
public class ConteudoAtividadeAtiva {

	private AtividadeAtiva atividadeAtiva;
	private byte[] conteudo;

	public AtividadeAtiva getAtividadeAtiva() {
		return atividadeAtiva;
	}

	public void setAtividadeAtiva(AtividadeAtiva atividadeAtiva) {
		this.atividadeAtiva = atividadeAtiva;
	}

	public byte[] getConteudo() {
		return conteudo;
	}

	public void setConteudo(byte[] conteudo) {
		this.conteudo = conteudo;
	}

}
