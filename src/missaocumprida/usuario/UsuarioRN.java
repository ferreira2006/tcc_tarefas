package missaocumprida.usuario;

import java.util.List;

import missaocumprida.CadastroDao;
import missaocumprida.util.DAOFactory;

public class UsuarioRN {

	private CadastroDao usuarioDAO;

	public UsuarioRN() {
		this.usuarioDAO = DAOFactory.criarUsuarioDAO();
	}

	public Usuario carregar(Long id) {
		return (Usuario) this.usuarioDAO.carregar(id);
	}

	public Usuario buscarPorLogin(String login) {
		return (Usuario) this.usuarioDAO.buscarPorParametro(login);
	}

	public void salvar(Usuario usuario) {

		Long codigo = usuario.getId();

		if (codigo == 0) {

			usuario.getPermissao().add("ROLE_USUARIO");

			this.usuarioDAO.salvar(usuario);

			// CategoriaRN categoriaRN = new CategoriaRN();
			// categoriaRN.salvaEstruturaPadrao(usuario);

		} else {
			this.usuarioDAO.atualizar(usuario);
		}
	}

	public void excluir(Usuario usuario) {

		// CategoriaRN categoriaRN = new CategoriaRN();
		// categoriaRN.excluir(usuario);

		this.usuarioDAO.excluir(usuario);
	}

	public List<Object> listar() {
		return this.usuarioDAO.listar();
	}

	/*
	 * public void enviarEmailPosCadastramento(Usuario usuario) throws
	 * RNException { //Enviando um e-mail conforme o idioma do usu�rio String[]
	 * info = usuario.getIdioma().split("_"); Locale locale = new
	 * Locale(info[0], info[1]);
	 * 
	 * String titulo = MensagemUtil.getMensagem(locale, "email_titulo"); String
	 * mensagem = MensagemUtil.getMensagem(locale, "email_mensagem",
	 * usuario.getNome(), usuario.getLogin(), usuario.getSenha()); try {
	 * EmailUtil emailUtil = new EmailUtil(); emailUtil.enviarEmail(null,
	 * usuario.getEmail(), titulo, mensagem); } catch (UtilException e) { throw
	 * new RNException(e); } }
	 */

}