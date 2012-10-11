package complementos;

public class Assunto {
	
	private String descricao;
	private boolean indTaxa;

	public Assunto() {}

	public Assunto(String descricao, boolean indTaxa) {
		this.descricao = descricao;
		this.indTaxa = indTaxa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean getIndTaxa() {
		return indTaxa;
	}

	public void setIndTaxa(boolean indTaxa) {
		this.indTaxa = indTaxa;
	}
}
