package missaocumprida.missao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import missaocumprida.usuario.Usuario;

@Entity
@Table(name = "missao")
public class Missao implements Serializable {

	private static final long serialVersionUID = 3640411042114337038L;

	@Id
	@GeneratedValue
	@Column(name = "id", columnDefinition = "INT(11)")
	private int id;

	@Column(name="assunto", columnDefinition="TEXT", nullable=false)
	private String assunto;
	
	@Column(name="conteudo", columnDefinition="TEXT", nullable=true)
	private String conteudo;
	
	@Column(name="providencias", columnDefinition="TEXT", nullable=true)
	private String providencias;

	@ManyToOne
	@JoinColumn(name = "id_chefe")
	private Usuario chefe;
	
	@ManyToOne
	@JoinColumn(name = "id_aux")
	private Usuario auxiliar;

	@Column(name = "dtcadastro", nullable = false, updatable = false)
	private Date dataCadastro;

	@Column(name = "ativo", nullable = false)
	private boolean ativo = false;

	
	public Missao() { }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getProvidencias() {
		return providencias;
	}

	public void setProvidencias(String providencias) {
		this.providencias = providencias;
	}

	public Usuario getChefe() {
		return chefe;
	}

	public void setChefe(Usuario chefe) {
		this.chefe = chefe;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Usuario getAuxiliar() {
		return auxiliar;
	}

	public void setAuxiliar(Usuario auxiliar) {
		this.auxiliar = auxiliar;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assunto == null) ? 0 : assunto.hashCode());
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result
				+ ((auxiliar == null) ? 0 : auxiliar.hashCode());
		result = prime * result + ((chefe == null) ? 0 : chefe.hashCode());
		result = prime * result
				+ ((conteudo == null) ? 0 : conteudo.hashCode());
		result = prime * result
				+ ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((providencias == null) ? 0 : providencias.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Missao other = (Missao) obj;
		if (assunto == null) {
			if (other.assunto != null)
				return false;
		} else if (!assunto.equals(other.assunto))
			return false;
		if (ativo != other.ativo)
			return false;
		if (auxiliar == null) {
			if (other.auxiliar != null)
				return false;
		} else if (!auxiliar.equals(other.auxiliar))
			return false;
		if (chefe == null) {
			if (other.chefe != null)
				return false;
		} else if (!chefe.equals(other.chefe))
			return false;
		if (conteudo == null) {
			if (other.conteudo != null)
				return false;
		} else if (!conteudo.equals(other.conteudo))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (id != other.id)
			return false;
		if (providencias == null) {
			if (other.providencias != null)
				return false;
		} else if (!providencias.equals(other.providencias))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return assunto;
	}

}
