package controller;

import java.util.ArrayList;

import model.bo.ProdutoBO;
import model.vo.Pesquisa;
import model.vo.Produto;

public class ProdutoController {
	ProdutoBO pBo = new ProdutoBO();
	
	public Produto cadastrarProduto(Produto produto) {
		
		pBo.cadastrar(produto);
		
		
		return produto;
	}

	public ArrayList<Produto> pesquisar(Pesquisa pesquisa) {
		
		return pBo.pesquisar(pesquisa);
	}

	public ArrayList<Produto> buscarCarrinho(int idLogado) {
		
		return pBo.buscarCarrinho(idLogado);
	}

	public ArrayList<Produto> meusProdutos(int idUsuario) {
		// TODO Auto-generated method stub
		return pBo.meusProdutos(idUsuario);
	}

	public int removerDaLoja(int idproduto) {
		// TODO Auto-generated method stub
		return pBo.removerDaLoja(idproduto);
	}
	
	

}
