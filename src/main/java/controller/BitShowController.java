package controller;

import java.util.ArrayList;

import model.dao.CarrinhoDAO;
import model.vo.Pesquisa;
import model.vo.Produto;
import model.vo.Usuario;

public class BitShowController {

	CarrinhoDAO carDAO = new CarrinhoDAO();
	UsuarioController usuarioCont = new UsuarioController();
	ProdutoController produtoCont = new ProdutoController();

	public CarrinhoDAO getCarDAO() {
		return carDAO;
	}

	public UsuarioController getUsuarioController() {
		return usuarioCont;
	}

	public ProdutoController getProdutoCont() {
		return produtoCont;
	}

	public ArrayList<Produto> pesquisar(Pesquisa pesquisa) {

		ArrayList<Produto> produtos = produtoCont.pesquisar(pesquisa);

		for (Produto p : produtos) {
			p.setVendedor(usuarioCont.pesquisarVendedorPorId(p.getVendedor()));
		}

		return produtos;
	}

	public ArrayList<Produto> buscarCarrinho(int idLogado) {
		
		ArrayList<Produto> produtos = produtoCont.buscarCarrinho(idLogado);
		
		for (Produto p : produtos) {
			p.setVendedor(usuarioCont.pesquisarVendedorPorId(p.getVendedor()));
		}

		return produtos;
	}

	

	
	
	
	
	
	
	
}
