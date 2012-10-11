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

public class ProcessoISS extends Processo{
	private int inscricaoISS;
	
	public ProcessoISS() {}

	public ProcessoISS(String numeroAno, Pessoa pessoa, Assunto assunto,
			String descricao, Date dataAbertura,
			DocumentoArrecadacao docArrecadacao, String usuarioCadastro,
			Pendencia pendencias, ArrayList<Documento> documentosObrigatorios,
			ArrayList<Documento> documentosEntrOpc,
			ArrayList<Situacao> situacao, ArrayList<Atos> atos,
			ArrayList<Tramitacao> tramitacao, int inscricaoISS) {
		super(numeroAno, pessoa, assunto, descricao, dataAbertura, docArrecadacao,
				usuarioCadastro, pendencias, documentosObrigatorios, documentosEntrOpc,
				situacao, atos, tramitacao);
		 this.inscricaoISS = inscricaoISS;
	}

	public int getInscricaoISS() {
		return inscricaoISS;
	}

	public void setInscricaoISS(int inscricaoISS) {
		this.inscricaoISS = inscricaoISS;
	}
	
}
