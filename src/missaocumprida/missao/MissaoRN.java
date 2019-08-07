package missaocumprida.missao;

import java.util.Date;
import java.util.List;

import missaocumprida.CadastroDao;
import missaocumprida.util.DAOFactory;

public class MissaoRN {

	private CadastroDao missaoDAO;

	public MissaoRN() {
		this.missaoDAO = DAOFactory.criarMissaoDAO();
	}

	public Missao carregar(Long id) {
		return (Missao) this.missaoDAO.carregar(id);
	}

	public Missao buscarPorLogin(String login) {
		return (Missao) this.missaoDAO.buscarPorParametro(login);
	}

	public void salvar(Missao missao) {

		int codigo = missao.getId();

		if (codigo == 0) {
			
			this.missaoDAO.salvar(missao);
		} else {
			this.missaoDAO.atualizar(missao);
		}
	}

	public void excluir(Missao missao) {

		
		this.missaoDAO.excluir(missao);
	}

	public List<Object> listar() {
		return this.missaoDAO.listar();
	}

	

}