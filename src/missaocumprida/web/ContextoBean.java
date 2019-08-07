package missaocumprida.web;

import java.io.Serializable;
import java.net.InetAddress;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import missaocumprida.usuario.Usuario;
import missaocumprida.usuario.UsuarioRN;


@ManagedBean(name = "contextoBean")
@SessionScoped
public class ContextoBean implements Serializable{

	private static final long serialVersionUID = -6911219435612540155L;
	
	private Usuario usuarioLogado = null;
	private String idSession = null;	
	private String ipSession = null;
	/*Pega apenas o nome do servidor*/
	private String nomePc = null;
	

	public Usuario getUsuarioLogado() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		String login = external.getRemoteUser();

		if (this.usuarioLogado == null || !login.equals(this.usuarioLogado.getEmail())) {

			if (login != null) {
				UsuarioRN usuarioRN = new UsuarioRN();
				this.usuarioLogado = usuarioRN.buscarPorLogin(login);

			}
		}
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuario) {
		this.usuarioLogado = usuario;
	}

	public String getIpSession() {
		 FacesContext context = FacesContext.getCurrentInstance();
	        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
	        return request.getRemoteAddr();
	}

	public void setIpSession(String ipSession) {
		this.ipSession = ipSession;
	}
	
	 public String getIdSession() {
    	 FacesContext context = FacesContext.getCurrentInstance();
         HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
         return session.getId();
    }

	public void setIdSession(String idSession) {
		this.idSession = idSession;
	}

	public String getNomePc() {
		String computername = "";
		try {
			computername = InetAddress.getLocalHost().getHostName();
		} catch (Exception e) {
			System.out.println("Exception caught =" + e.getMessage());
		}
		return computername;		
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setNomePc(String nomePc) {
		this.nomePc = nomePc;
	}

		
}
