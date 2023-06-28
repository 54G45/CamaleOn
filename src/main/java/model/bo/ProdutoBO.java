package model.bo;

import java.util.ArrayList;

import model.dao.ProdutoDAO;
import model.dao.UsuarioDAO;
import model.vo.Pesquisa;
import model.vo.Produto;

public class ProdutoBO {

	private ProdutoDAO pDao = new ProdutoDAO();

	public Produto cadastrar(Produto produto) {

		pDao.cadastrar(produto);
		return produto;
	}

	public ArrayList<Produto> pesquisar(Pesquisa pesquisa) {

		return pDao.pesquisar(pesquisa);
	}

}
