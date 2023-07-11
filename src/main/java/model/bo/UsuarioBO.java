package model.bo;

import model.dao.UsuarioDAO;
import model.vo.Usuario;

public class UsuarioBO {
	private UsuarioDAO uDao = new UsuarioDAO();

	public int cadastrar(Usuario u) {
		return uDao.cadastrar(u);

	}
	
	public Usuario login(Usuario u) {
		uDao.login(u);
		return u;
	}

	public Usuario pesquisarVendedorPorId(Usuario vendedor) {
		
		vendedor = uDao.pesquisarVendedorPorId(vendedor);
		
		
		return vendedor;
	}

	public int editarUsuario(Usuario user) {
		// TODO Auto-generated method stub
		return uDao.editarUsuario(user);
	}

}
