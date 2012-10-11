package complementos;

public class Situacao {
	
	private String situacao;
	private String dataInicio;
	private String dataFim;
	private Motivo_de_Encerramento motivo;
	
	public Situacao() {
	}
	
	public Situacao(String situacao, String dataInicio, String dataFim) {
		
		this.situacao = situacao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	
	public Motivo_de_Encerramento getMotivo() {
		return motivo;
	}

	public void setMotivo(Motivo_de_Encerramento motivo) {
		this.motivo = motivo;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String descricao) {
		this.situacao = descricao;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	
}
