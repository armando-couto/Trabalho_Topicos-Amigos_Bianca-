package documentos;

public class Documento {
	private String sigla;
	private String nome;
	
	public Documento() {}

	public Documento(String sigla, String nome) {
		this.sigla = sigla;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}
