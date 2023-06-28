package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import controller.BitShowController;
import model.vo.Usuario;

public class testeLogin {
	
	BitShowController cont = new BitShowController();

	@Test
	public void test() {
		
		Usuario retornoEsperado = new Usuario();
		retornoEsperado.setId(12);
		retornoEsperado.setEmail("milhouse@senac");
		retornoEsperado.setSenha("senhaForte");
		
		Usuario retornoFeito = new Usuario();
		
		retornoFeito.setEmail("milhouse@senac");
		retornoFeito.setSenha("senhaForte");
		retornoFeito = cont.getUsuarioController().login(retornoFeito);
		
		

		assertEquals(retornoEsperado.getId(), retornoFeito.getId());
		assertEquals(retornoEsperado.getEmail(), retornoFeito.getEmail());
		assertEquals(retornoEsperado.getSenha(), retornoFeito.getSenha());
		
		
	}

}
