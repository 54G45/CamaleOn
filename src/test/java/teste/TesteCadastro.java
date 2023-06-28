package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import controller.BitShowController;
import model.vo.Usuario;

public class TesteCadastro {
	
	BitShowController cont = new BitShowController();
	
	@Test
	public void test() {
		int retornoEsperado = 1;
		
		int retornoFeito = 0;
		
		Usuario user = new Usuario(); 
		retornoFeito = cont.getUsuarioController().cadastrar(user);
		
		assertEquals(retornoEsperado, retornoEsperado);
		
	}

}
