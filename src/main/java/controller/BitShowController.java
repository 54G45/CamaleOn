package controller;

import java.util.ArrayList;

import model.vo.Pesquisa;
import model.vo.Produto;
import model.vo.Usuario;

public class BitShowController {
	
	UsuarioController usuarioCont = new UsuarioController();
	ProdutoController produtoCont = new ProdutoController();

	public UsuarioController getUsuarioController() {
		return usuarioCont;
	}

	public ProdutoController getProdutoCont() {
		return produtoCont;
	}

	public ArrayList<Produto> pesquisar(Pesquisa pesquisa) {
		
		ArrayList<Produto> produtos = produtoCont.pesquisar(pesquisa);
		
		for(Produto p : produtos) {
			p.setVendedor(usuarioCont.pesquisarVendedorPorId(p.getVendedor()));
		}
		
		
		return produtos;
	}

	

}
