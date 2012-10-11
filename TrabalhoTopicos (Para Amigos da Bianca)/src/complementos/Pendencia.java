package complementos;

import java.util.Date;

public class Pendencia {
	private Date dataPendencia;
	private String descricao;
	private Date dataRegularizacao	;
	
	public Pendencia() {}
	
	public Pendencia(Date dataPendencia, String descricao, Date dataRegularizacao) {
		this.dataPendencia = dataPendencia;
		this.descricao = descricao;
		this.dataRegularizacao = dataRegularizacao;
	}

	public Date getDatePendencia() {
		return dataPendencia;
	}

	public void setDataPendencia(Date dataPendencia) {
		this.dataPendencia = dataPendencia;
	}

	public Date getDataRegularizacao() {
		return dataRegularizacao;
	}

	public void setDataRegularizacao(Date dataRegularizacao) {
		this.dataRegularizacao = dataRegularizacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
