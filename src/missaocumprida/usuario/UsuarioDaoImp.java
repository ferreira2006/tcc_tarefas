package missaocumprida.usuario;

import java.util.List;

import missaocumprida.CadastroDao;
import missaocumprida.CadastroDaoImp;
import missaocumprida.graduacao.Graduacao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;

public class UsuarioDaoImp extends CadastroDaoImp implements CadastroDao {

	
	@Override
	public void salvar(Object usuario) {
		super.getSession().save(usuario);		
	}
	
	@Override
	public void atualizar(Object usuario) {
		super.getSession().update(usuario);
	}

	@Override
	public void excluir(Object usuario) {
		//super.getSession().delete(usuario);
		((Usuario) usuario).setAtivo(false);
		super.getSession().update(usuario);
	}

	@Override
	public Object carregar(Long id) {
		String hql = "select u from Usuario u where u.id = :id";
		Query consulta = super.getSession().createQuery(hql);
		consulta.setLong("id", id);

		//Mostrar primeiramente com o list e depois apresentar o uniqueResult
		return (Usuario) consulta.uniqueResult();
	}

	@Override
	public Object buscarPorParametro(String descricao) {
		String hql = "select u from Usuario u where u.email = :descricao";
		Query consulta = super.getSession().createQuery(hql);
		consulta.setString("descricao", descricao);

		//Mostrar primeiramente com o list e depois apresentar o uniqueResult
		return (Usuario) consulta.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> listar() {
		Criteria filtro = super.getSession().createCriteria(Usuario.class);	
		filtro.addOrder(Order.asc("nome"));
		return filtro.list();		
	}

}
