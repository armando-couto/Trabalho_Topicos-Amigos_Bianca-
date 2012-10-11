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



public class ProcessoAlvaraFuncionamento extends Processo {

	private int inscricaoImovel;
	private int areaImovel;
	private int codigo;

	public ProcessoAlvaraFuncionamento() {}

	public ProcessoAlvaraFuncionamento(String numeroAno, Pessoa pessoa,
			Assunto assunto, String descricao, Date dataAbertura,
			DocumentoArrecadacao docArrecadacao, String usuarioCadastro,
			Pendencia pendencias, ArrayList<Documento> documentosObrigatorios,
			ArrayList<Documento> documentosEntrOpc,
			ArrayList<Situacao> situacao, ArrayList<Atos> atos,
			ArrayList<Tramitacao> tramitacao, int inscricaoImovel, int areaImovel,
			int codigo) {
		super(numeroAno, pessoa, assunto, descricao, dataAbertura, docArrecadacao,
				usuarioCadastro, pendencias, documentosObrigatorios, documentosEntrOpc,
				situacao, atos, tramitacao);
		this.inscricaoImovel = inscricaoImovel;
		this.areaImovel = areaImovel;
		this.codigo = codigo;
	}

	public int getInscricaoImovel() {
		return inscricaoImovel;
	}

	public void setInscricaoImovel(int inscricaoImovel) {
		this.inscricaoImovel = inscricaoImovel;
	}

	public int getAreaImovel() {
		return areaImovel;
	}

	public void setAreaImovel(int areaImovel) {
		this.areaImovel = areaImovel;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}
