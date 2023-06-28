package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import controller.BitShowController;
import model.vo.Produto;

public class TesteBuscarCarrrinho {
	BitShowController cont = new BitShowController();
	
	@Test
	public void test() {
		int resultadoEsperado = 1;
		
		int idUsuario = 1;
		
		ArrayList<Produto >produtos = cont.buscarCarrinho(idUsuario);
		int resultadoFeito = produtos.size();
		
		
		assertEquals(resultadoEsperado, resultadoFeito);
	}

}
