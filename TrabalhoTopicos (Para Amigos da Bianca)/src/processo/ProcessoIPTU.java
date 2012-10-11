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

public class ProcessoIPTU extends Processo {
	
	private int inscricao_imovel;

	public ProcessoIPTU() {}

	public ProcessoIPTU(String numeroAno, Pessoa pessoa, Assunto assunto,
			String descricao, Date dataAbertura,
			DocumentoArrecadacao docArrecadacao, String usuarioCadastro,
			Pendencia pendencias, ArrayList<Documento> documentosObrigatorios,
			ArrayList<Documento> documentosEntrOpc,
			ArrayList<Situacao> situacao, ArrayList<Atos> atos,
			ArrayList<Tramitacao> tramitacao, int inscricao_imovel) {
		super(numeroAno, pessoa, assunto, descricao, dataAbertura, docArrecadacao,
				usuarioCadastro, pendencias, documentosObrigatorios, documentosEntrOpc,
				situacao, atos, tramitacao);
		this.inscricao_imovel = inscricao_imovel;
		
	}

	public int getInscricao_imovel() {
		return inscricao_imovel;
	}

	public void setInscricao_imovel(int inscricao_imovel) {
		this.inscricao_imovel = inscricao_imovel;
	}
}
