package comum;

public class Pessoa {

	private String nome;
	private String cpf;
	private String rg;
	private String estado_civil;
	private String endereco;
	private String endereco_correspondencia;
	private String telefone;
	
	public Pessoa() {}
	
	public Pessoa(String nome, String cpf, String rg, String estado_civil,
			String endereco, String endereco_correspondencia, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.estado_civil = estado_civil;
		this.endereco = endereco;
		this.endereco_correspondencia = endereco_correspondencia;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEstado_civil() {
		return estado_civil;
	}

	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEndereco_correspondencia() {
		return endereco_correspondencia;
	}

	public void setEndereco_correspondencia(String endereco_correspondencia) {
		this.endereco_correspondencia = endereco_correspondencia;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
