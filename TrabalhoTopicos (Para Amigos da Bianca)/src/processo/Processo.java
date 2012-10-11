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



public abstract class Processo {	
	
	protected String numeroAno;
	protected Pessoa pessoa;
	protected Assunto assunto;
	protected String descricao;
	protected Date dataAbertura;
	protected DocumentoArrecadacao docArrecadacao;	
	protected String usuarioCadastro;
	protected Pendencia pendencias;
	
	protected ArrayList<Documento> documentosObrigatorios;
	protected ArrayList<Documento> documentosEntrOpc;
	protected ArrayList<Situacao> situacao;
	protected ArrayList<Atos> atos;
	protected ArrayList<Tramitacao> tramitacao;
	
	public Processo() {}

	public Processo(String numeroAno, Pessoa pessoa, Assunto assunto,
			String descricao, Date dataAbertura,
			DocumentoArrecadacao docArrecadacao, String usuarioCadastro,
			Pendencia pendencias, ArrayList<Documento> documentosObrigatorios,
			ArrayList<Documento> documentosEntrOpc,
			ArrayList<Situacao> situacao, ArrayList<Atos> atos,
			ArrayList<Tramitacao> tramitacao) {
		this.numeroAno = numeroAno;
		this.pessoa = pessoa;
		this.assunto = assunto;
		this.descricao = descricao;
		this.dataAbertura = dataAbertura;
		this.docArrecadacao = docArrecadacao;
		this.usuarioCadastro = usuarioCadastro;
		this.pendencias = pendencias;
		this.documentosObrigatorios = documentosObrigatorios;
		this.documentosEntrOpc = documentosEntrOpc;
		this.situacao = situacao;
		this.atos = atos;
		this.tramitacao = tramitacao;
	}

	public String getNumeroAno() {
		return numeroAno;
	}

	public void setNumeroAno(String numeroAno) {
		this.numeroAno = numeroAno;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Assunto getAssunto() {
		return assunto;
	}

	public void setAssunto(Assunto assunto) {
		this.assunto = assunto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public DocumentoArrecadacao getDocArrecadacao() {
		return docArrecadacao;
	}

	public void setDocArrecadacao(DocumentoArrecadacao docArrecadacao) {
		this.docArrecadacao = docArrecadacao;
	}

	public String getUsuarioCadastro() {
		return usuarioCadastro;
	}

	public void setUsuarioCadastro(String usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}

	public Pendencia getPendencias() {
		return pendencias;
	}

	public void setPendencias(Pendencia pendencias) {
		this.pendencias = pendencias;
	}

	public ArrayList<Documento> getDocumentosObrigatorios() {
		return documentosObrigatorios;
	}

	public void setDocumentosObrigatorios(
			ArrayList<Documento> documentosObrigatorios) {
		this.documentosObrigatorios = documentosObrigatorios;
	}

	public ArrayList<Documento> getDocumentosEntrOpc() {
		return documentosEntrOpc;
	}

	public void setDocumentosEntrOpc(ArrayList<Documento> documentosEntrOpc) {
		this.documentosEntrOpc = documentosEntrOpc;
	}

	public ArrayList<Situacao> getSituacao() {
		return situacao;
	}

	public void setSituacao(ArrayList<Situacao> situacao) {
		this.situacao = situacao;
	}

	public ArrayList<Atos> getAtos() {
		return atos;
	}

	public void setAtos(ArrayList<Atos> atos) {
		this.atos = atos;
	}

	public ArrayList<Tramitacao> getTramitacao() {
		return tramitacao;
	}

	public void setTramitacao(ArrayList<Tramitacao> tramitacao) {
		this.tramitacao = tramitacao;
	} 
}
