package missaocumprida.util;

import missaocumprida.CadastroDao;
import missaocumprida.graduacao.GraduacaoDaoImp;
import missaocumprida.missao.MissaoDaoImp;
import missaocumprida.usuario.UsuarioDaoImp;

public class DAOFactory {

	public static CadastroDao criarMissaoDAO() {
		MissaoDaoImp missaoDao = new MissaoDaoImp();
		missaoDao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return missaoDao;
	}
	
	public static CadastroDao criarUsuarioDAO() {
		UsuarioDaoImp usuarioDao = new UsuarioDaoImp();
		usuarioDao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDao;
	}
	
	public static CadastroDao criarGraduacaoDAO() {
		GraduacaoDaoImp graduacaoDao = new GraduacaoDaoImp();
		graduacaoDao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return graduacaoDao;
	}
	
}
