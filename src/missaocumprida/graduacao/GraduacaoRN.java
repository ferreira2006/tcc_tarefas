package missaocumprida.graduacao;

import java.util.List;

import missaocumprida.CadastroDao;
import missaocumprida.util.DAOFactory;

public class GraduacaoRN {

	private CadastroDao sessaoDAO;

	public GraduacaoRN() {
		this.sessaoDAO = DAOFactory.criarGraduacaoDAO();
	}
	
	public Graduacao carregar(Long id) {
		return (Graduacao) this.sessaoDAO.carregar(id);
	}

	public Graduacao buscarPorParametro(String descricao) {
		return (Graduacao) this.sessaoDAO.buscarPorParametro(descricao);
	}
	
	public void salvar(Graduacao sessao) {
		Long codigo = sessao.getId();
		
		if (codigo == null || codigo == 0) {
			this.sessaoDAO.salvar(sessao);
		} else {
			this.sessaoDAO.atualizar(sessao);
		}
	}
	
	public void excluir(Graduacao sessao) {		
		this.sessaoDAO.excluir(sessao);
	}
	
	public List<Object> listar() {
		return this.sessaoDAO.listar();
	}	
	
}
