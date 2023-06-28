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
	
	

}
