package br.com.mauriciotsilva.consultaendereco.logradouro;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CepTest {

	@Test(expected = CepInvalidoExpcetion.class)
	public void naoDeveTerLetras() {
		new Cep("0100100D");
	}

	@Test
	public void deveTerOitoDigitos() {
		Cep cep = new Cep("0230");
		assertEquals(8, cep.getNumero().length());
	}

	@Test
	public void deveCompletarComZerosADireita() {
		Cep cep = new Cep("01001");
		assertEquals("01001000", cep.getNumero());
	}
}
