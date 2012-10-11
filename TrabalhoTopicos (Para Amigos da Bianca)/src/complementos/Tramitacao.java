package complementos;

import java.util.Date;


public class Tramitacao {
	private Date dataEnvio;
	private String usuarioEnvio;
	private String localDestino;
	private String usuarioReceb;
	private Date dataReceb;

	public Tramitacao() {}

	public Tramitacao(Date dataEnvio, String usuarioEnvio,
			String localDestino, String usuarioReceb, Date dataReceb) {
		this.dataEnvio = dataEnvio;
		this.usuarioEnvio = usuarioEnvio;
		this.localDestino = localDestino;
		this.usuarioReceb = usuarioReceb;
		this.dataReceb = dataReceb;
	}

	public Date getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public String getUsuarioEnvio() {
		return usuarioEnvio;
	}

	public void setUsuarioEnvio(String usuarioEnvio) {
		this.usuarioEnvio = usuarioEnvio;
	}

	public String getLocalDestino() {
		return localDestino;
	}

	public void setLocalDestino(String localDestino) {
		this.localDestino = localDestino;
	}

	public String getUsuarioReceb() {
		return usuarioReceb;
	}

	public void setUsuarioReceb(String usuarioReceb) {
		this.usuarioReceb = usuarioReceb;
	}

	public Date getDataReceb() {
		return dataReceb;
	}

	public void setDataReceb(Date dataReceb) {
		this.dataReceb = dataReceb;
	}
}
