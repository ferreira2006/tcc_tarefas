package missaocumprida.web;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import missaocumprida.usuario.Usuario;
import missaocumprida.usuario.UsuarioRN;

import org.springframework.util.DigestUtils;

@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 5784495074446694788L;

	private Usuario usuario;
	private String confirmarSenha = null;
	private int totalUsuarios = 0;
	private List<Object> lista;
	private String destinoSalvar;
	private String senhaCriptografada;
	private Boolean edicao;
	private List<Usuario> objetosFiltrados;

	public UsuarioBean() {
		usuario = new Usuario();
		edicao = Boolean.FALSE;
	}

	public String novo() {
		destinoSalvar = "usuarioEdicao";
		usuario = new Usuario();
		usuario.setAtivo(true);
		confirmarSenha = null;
		edicao = Boolean.FALSE;
		return "usuario";
	}

	public String editar() {
		this.confirmarSenha = this.usuario.getSenha();
		this.senhaCriptografada = this.usuario.getSenha();
		edicao = Boolean.TRUE;
		return "/admin/usuario";
	}

	public String salvar() {

		FacesContext context = FacesContext.getCurrentInstance();
		String senha = this.usuario.getSenha();

		if (senha != null && senha.trim().length() > 0
				&& !senha.equals(this.confirmarSenha)) {
			FacesMessage facesMessage = new FacesMessage(
					"A senha não foi confirmada corretamente");
			context.addMessage(null, facesMessage);
			return null;
		}

		if (edicao) {
			this.usuario.setSenha(this.senhaCriptografada);
		} else {
			if (senha != null && senha.trim().length() == 0) {
				this.usuario.setSenha(this.senhaCriptografada);
			} else {
				String senhaCripto = DigestUtils.md5DigestAsHex(senha
						.getBytes());
				this.usuario.setSenha(senhaCripto);
			}
		}

		UsuarioRN usuarioRN = new UsuarioRN();

		if (!this.edicao) {
			this.usuario.setDataCadastro(new Date());
		}

		usuarioRN.salvar(this.usuario);

		this.totalUsuarios = usuarioRN.listar().size();

		return this.destinoSalvar;
	}

	public String excluir() {
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.excluir(this.usuario);
		this.lista = null;
		return null;
	}

	public String ativar() {
		this.usuario.setAtivo(!usuario.isAtivo());
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);
		return null;
	}

	public String atribuiPermissao(Usuario usuario, String permissao) {
		this.usuario = usuario;
		Set<String> permissoes = this.usuario.getPermissao();

		if (permissoes.contains(permissao)) {
			permissoes.remove(permissao);
		} else {
			permissoes.add(permissao);
		}
		return null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public int getTotalUsuarios() {
		return totalUsuarios;
	}

	public void setTotalUsuarios(int totalUsuarios) {
		this.totalUsuarios = totalUsuarios;
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
			UsuarioRN usuarioRN = new UsuarioRN();
			this.lista = usuarioRN.listar();
		}

		return this.lista;
	}

	public String getSenhaCriptografada() {
		return senhaCriptografada;
	}

	public void setSenhaCriptografada(String senhaCriptografada) {
		this.senhaCriptografada = senhaCriptografada;
	}

	public Boolean getEdicao() {
		return edicao;
	}

	public void setEdicao(Boolean edicao) {
		this.edicao = edicao;
	}

	public List<Usuario> getObjetosFiltrados() {
		return objetosFiltrados;
	}

	public void setObjetosFiltrados(List<Usuario> objetosFiltrados) {
		this.objetosFiltrados = objetosFiltrados;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}