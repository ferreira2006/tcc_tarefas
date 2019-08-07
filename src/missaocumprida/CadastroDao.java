package missaocumprida;

import java.util.List;

public interface CadastroDao {

	public void salvar(Object cadastro);

	public void atualizar(Object cadastro);

	public void excluir(Object cadastro);

	public Object carregar(Long id);

	public Object buscarPorParametro(String parametro);

	public List<Object> listar();

}
