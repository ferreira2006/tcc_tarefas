package missaocumprida.web;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import missaocumprida.missao.Missao;
import missaocumprida.missao.MissaoRN;

@ManagedBean(name = "missaoBean")
@RequestScoped
public class MissaoBean implements Serializable {

	private static final long serialVersionUID = -4584319556806130535L;
	
	private Missao missao;	
	private List<Object> lista;
	private String destinoSalvar;
	private Boolean edicao;
	private List<Missao> objetosFiltrados;

	public MissaoBean() {
		missao = new Missao();
		edicao = Boolean.FALSE;
	}

	public String novo() {
		destinoSalvar = "missaoEdicao";
		missao = new Missao();
		missao.setAtivo(true);
		missao.setDataCadastro(new Date());	
		edicao = Boolean.FALSE;
		return "missao";
	}

	public String editar() {
		edicao = Boolean.TRUE;		
		return "/restrito/missao";
	}

	public String salvar() {

		MissaoRN missaoRN = new MissaoRN();
		missao.setDataCadastro(new Date());	
		
		missao.setChefe(new ContextoBean().getUsuarioLogado());
		
		missaoRN.salvar(this.missao);

		return this.destinoSalvar;
	}

	public String excluir() {
		MissaoRN missaoRN = new MissaoRN();
		missaoRN.excluir(this.missao);
		this.lista = null;
		return null;
	}

	public String desativar() {
		this.missao.setAtivo(false);
		MissaoRN missaoRN = new MissaoRN();
		missaoRN.salvar(this.missao);
		this.lista = null;
		return null;
	}

	public Missao getMissao() {
		return missao;
	}

	public void setMissao(Missao missao) {
		this.missao = missao;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public void setLista(List<Object> lista) {
		this.lista = lista;
	}

	public List<Object> getLista() {
		
		if (this.lista == null) {
			MissaoRN missaoRN = new MissaoRN();
			this.lista = missaoRN.listar();
		}

		return this.lista;
	}

	public Boolean getEdicao() {
		return edicao;
	}

	public void setEdicao(Boolean edicao) {
		this.edicao = edicao;
	}

	public List<Missao> getObjetosFiltrados() {
		return objetosFiltrados;
	}

	public void setObjetosFiltrados(List<Missao> objetosFiltrados) {
		this.objetosFiltrados = objetosFiltrados;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}