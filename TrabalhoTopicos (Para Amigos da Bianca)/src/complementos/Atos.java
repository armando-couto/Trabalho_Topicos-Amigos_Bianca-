package complementos;

import java.util.Date;

public class Atos {
	private Date data;
	private String descricao;
	private String usuario;
	
	public Atos() {}

	public Atos(Date data, String descricao, String usuario) {
		this.data = data;
		this.descricao = descricao;
		this.usuario = usuario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
