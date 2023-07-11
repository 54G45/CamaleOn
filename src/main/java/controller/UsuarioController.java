package controller;

import model.bo.UsuarioBO;
import model.vo.Usuario;

public class UsuarioController {
	UsuarioBO uBo = new UsuarioBO();
	
	public int cadastrar(Usuario u){
		return uBo.cadastrar(u);
	}
	
	public Usuario login(Usuario u) {
		uBo.login(u);
		return u;
	}
	
	public Usuario pesquisarVendedorPorId(Usuario vendedor) {
		
		vendedor = uBo.pesquisarVendedorPorId(vendedor) ;
		return vendedor;
	}

	public int editarUsuario(Usuario user) {
		// TODO Auto-generated method stub
		return uBo.editarUsuario(user);
	}

}
