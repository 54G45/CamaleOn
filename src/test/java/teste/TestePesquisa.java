package teste;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import controller.BitShowController;
import model.vo.Pesquisa;
import model.vo.Produto;

public class TestePesquisa {
	
	BitShowController cont = new BitShowController();

	@Test
	public void test() {
		
		
		Pesquisa pesquisa = new Pesquisa();
		pesquisa.setNomeProduto("");
		pesquisa.setCategoria("cpu");
		ArrayList<Produto> retornoFeito = new ArrayList<Produto>();
		retornoFeito = cont.pesquisar(pesquisa);
		retornoFeito.size();
		
		assertEquals(1, retornoFeito.size());
		
		
	}

	
	
	
	
}
