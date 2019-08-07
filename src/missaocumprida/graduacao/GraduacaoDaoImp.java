package missaocumprida.graduacao;

import java.util.List;

import missaocumprida.CadastroDao;
import missaocumprida.CadastroDaoImp;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class GraduacaoDaoImp extends CadastroDaoImp implements CadastroDao {
	
	@Override
	public void salvar(Object graduacao) {
		super.getSession().save(graduacao);		
	}
	
	@Override
	public void atualizar(Object graduacao) {
		super.getSession().update(graduacao);
	}

	// Exclusão Lógica 
	@Override
	public void excluir(Object graduacao) {
		//this.session.delete(graduacao);
		((Graduacao) graduacao).setAtivo(false);
		super.getSession().update(graduacao);
	}

	@Override
	public Object carregar(Long id) {
		String hql = "select u from Graduacao u where u.id = :id";
		Query consulta = super.getSession().createQuery(hql);
		consulta.setLong("id", id);
		return (Graduacao) consulta.uniqueResult();
	}

	@Override
	public Object buscarPorParametro(String descricao) {
		String hql = "select u from Graduacao u where u.descricao = :descricao";
		Query consulta = super.getSession().createQuery(hql);
		consulta.setString("descricao", descricao);
		return (Graduacao) consulta.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> listar() {
		Criteria filtro = super.getSession().createCriteria(Graduacao.class);
		filtro.add(Restrictions.eq("ativo", Boolean.TRUE) );
		filtro.addOrder(Order.asc("descricao"));
		return filtro.list();		
	}
	
}
