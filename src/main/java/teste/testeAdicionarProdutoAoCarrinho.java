package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.BitShowController;

public class testeAdicionarProdutoAoCarrinho {
	
	BitShowController cont = new BitShowController();

	@Test
	public void test() {
		int resultadoEsperado = 1;
		
		int idProduto = 1;
		int idUsuario = 1;
		
		int resultadoFeito = cont.getCarDAO().adicionarAoCarrinho(idProduto, idUsuario);
		
		assertEquals(resultadoEsperado, resultadoFeito);
	}

}
