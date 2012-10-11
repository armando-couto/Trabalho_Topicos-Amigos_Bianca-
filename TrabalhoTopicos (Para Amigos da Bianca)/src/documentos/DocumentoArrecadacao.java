package documentos;

public class DocumentoArrecadacao {
	private int numero;
	private boolean indPago;
	
	public DocumentoArrecadacao() {}

	public DocumentoArrecadacao(int numero, boolean indPago) {
		this.numero = numero;
		this.indPago = indPago;
	}

	public boolean isIndPago() {
		return indPago;
	}

	public void setIndPago(boolean indPago) {
		this.indPago = indPago;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
}
