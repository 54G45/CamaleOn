package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import controller.BitShowController;
import model.vo.Produto;
import model.vo.Usuario;

public class TesteCadastroProduto {
	BitShowController cont = new BitShowController();

	@Test
	public void test() {
		
		Produto retornoEsperado = new Produto();
		retornoEsperado.setId(1);
		retornoEsperado.setNome("amd ryzen 5");
		retornoEsperado.setDescricao("processador 8/16 nucleos");
		retornoEsperado.setCategoria("cpu");
		retornoEsperado.setPreco("1500,00");
		Usuario user2 = new Usuario();
		user2.setUsuario("milhouse");
		retornoEsperado.setVendedor(user2);
		
		Produto retornoFeito = new Produto();
		retornoFeito.setNome("amd ryzen 5");
		retornoFeito.setDescricao("processador 8/16 nucleos");
		retornoFeito.setCategoria("cpu");
		retornoFeito.setPreco("1500,00");
		Usuario user1 = new Usuario();
		user1.setUsuario("milhouse");
		retornoFeito.setVendedor(user1);
		cont.getProdutoCont().cadastrarProduto(retornoFeito);
		
		assertEquals(retornoEsperado.getId(), retornoFeito.getId());
		
	}

}
