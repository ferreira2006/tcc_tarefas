package missaocumprida.missao;

import java.util.List;

import missaocumprida.CadastroDao;
import missaocumprida.CadastroDaoImp;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

public class MissaoDaoImp extends CadastroDaoImp implements CadastroDao {

	public void salvar(Object missao) {
		super.getSession().save(missao);
	}

	public void atualizar(Object missao) {
		super.getSession().update(missao);
	}

	public void excluir(Object missao) {
		super.getSession().delete(missao);
	}

	public Object carregar(int id) {
		// O hibernate nao conseguira fazer a carga caso seja passado o Missao
		// no parametro, tem que ser diretamente a chave (integer)
		return (Missao) super.getSession().get(Missao.class, id);
	}

	public Object buscarPorParamentro(String parametro) {
		String hql = "select u from Missao u where u.assunto = :parametro";
		Query consulta = super.getSession().createQuery(hql);
		consulta.setString("parametro", parametro);

		// Mostrar primeiramente com o list e depois apresentar o uniqueResult
		return (Missao) consulta.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Object> listar() {
	//	return super.getSession().createCriteria(Missao.class).list();
		
		Criteria filtro = super.getSession().createCriteria(Missao.class);
		filtro.add(Restrictions.eq("ativo", Boolean.TRUE) );		
		return filtro.list();		
	}

	@Override
	public Object buscarPorParametro(String parametro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object carregar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
