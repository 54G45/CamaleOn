package controller;

import model.bo.UsuarioBO;
import model.vo.Usuario;

public class UsuarioController {
	UsuarioBO uBo = new UsuarioBO();
	
	public void cadastrar(Usuario u){
		uBo.cadastrar(u);
	}
	
	public Usuario login(Usuario u) {
		uBo.login(u);
		return u;
	}
	
	public Usuario pesquisarVendedorPorId(Usuario vendedor) {
		
		vendedor = uBo.pesquisarVendedorPorId(vendedor) ;
		return vendedor;
	}

}
