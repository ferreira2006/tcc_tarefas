package missaocumprida.web;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import missaocumprida.graduacao.Graduacao;
import missaocumprida.graduacao.GraduacaoRN;

@ManagedBean(name="graduacaoBean")
@RequestScoped
public class GraduacaoBean implements Serializable {

	private static final long serialVersionUID = 800940474231232726L;
	private Graduacao graduacao;
	private List<Object> lista;
	private String destinoSalvar;
	
	public GraduacaoBean() {
		graduacao = new Graduacao();
	}

	public String novo() {		
		destinoSalvar = "graduacaoEdicao";		
		graduacao = new Graduacao();			
		return "graduacao";
	}
	
	public String editar(){		
		return "/restrito/graduacao";
	}
	
	public String salvar() {
		GraduacaoRN graduacaoRN = new GraduacaoRN();
		this.graduacao.setAtivo(true);
		graduacaoRN.salvar(this.graduacao);				
		return this.destinoSalvar;
	}
	
	public String excluir(){
		GraduacaoRN graduacaoRN = new GraduacaoRN();		
		graduacaoRN.excluir(this.graduacao);
		this.lista = null;
		return null;
	}

	public Graduacao getGraduacao() {
		return graduacao;
	}

	public void setGraduacao(Graduacao graduacao) {
		this.graduacao = graduacao;
	}

	public List<Object> getLista() {
		if (this.lista == null) {
			GraduacaoRN graduacaoRN = new GraduacaoRN();
			this.lista = graduacaoRN.listar();
		}
		
		return this.lista;
	}

	public void setLista(List<Object> lista) {
		this.lista = lista;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}
}
