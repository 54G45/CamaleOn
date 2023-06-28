package model.bo;

import model.dao.UsuarioDAO;
import model.vo.Usuario;

public class UsuarioBO {
	private UsuarioDAO uDao = new UsuarioDAO();

	public void cadastrar(Usuario u) {
		uDao.cadastrar(u);

	}
	
	public Usuario login(Usuario u) {
		uDao.login(u);
		return u;
	}

	public Usuario pesquisarVendedorPorId(Usuario vendedor) {
		
		vendedor = uDao.pesquisarVendedorPorId(vendedor);
		
		
		return vendedor;
	}

}
