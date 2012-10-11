package processo;

import java.util.ArrayList;
import java.util.Date;


import complementos.Assunto;
import complementos.Atos;
import complementos.Pendencia;
import complementos.Situacao;
import complementos.Tramitacao;
import comum.Pessoa;

import documentos.Documento;
import documentos.DocumentoArrecadacao;


public class ProcessoPropagandaPublicidade extends Processo{
	
	private String tipoEngenho;
	private int areaPlaca;
	private String endereco;
	
	public ProcessoPropagandaPublicidade() {}

	public ProcessoPropagandaPublicidade(String numeroAno, Pessoa pessoa,
			Assunto assunto, String descricao, Date dataAbertura,
			DocumentoArrecadacao docArrecadacao, String usuarioCadastro,
			Pendencia pendencias, ArrayList<Documento> documentosObrigatorios,
			ArrayList<Documento> documentosEntrOpc,
			ArrayList<Situacao> situacao, ArrayList<Atos> atos,
			ArrayList<Tramitacao> tramitacao, String tipoEngenho,
			int areaPlaca, String endereco) {
		super(numeroAno, pessoa, assunto, descricao, dataAbertura, docArrecadacao,
				usuarioCadastro, pendencias, documentosObrigatorios, documentosEntrOpc,
				situacao, atos, tramitacao);
		this.tipoEngenho = tipoEngenho;
		this.areaPlaca = areaPlaca;
		this.endereco = endereco;
	}

	public String getTipoEngenho() {
		return tipoEngenho;
	}

	public void setTipoEngenho(String tipoEngenho) {
		this.tipoEngenho = tipoEngenho;
	}

	public int getAreaPlaca() {
		return areaPlaca;
	}

	public void setAreaPlaca(int areaPlaca) {
		this.areaPlaca = areaPlaca;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
