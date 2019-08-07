package missaocumprida;

import org.hibernate.Session;

public class CadastroDaoImp {
	
	private Session	 session;

	public void setSession(Session session) {
		this.session = session;
	}

	public Session getSession() {
		return session;
	}

}
