package br.com.mauriciotsilva;

import static br.com.mauriciotsilva.App.firstChar;
import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import br.com.mauriciotsilva.stream.Stream;
import br.com.mauriciotsilva.stream.StreamImpl;

public class AppTest {

	@Test
	public void deveRetornarLetraBEmMinusculo() {
		Stream stream = new StreamImpl("aAbBABac");
		assertEquals('b', firstChar(stream));
	}

	@Test
	public void deveRetornarLetraBEmMaiusculo() {
		Stream stream = new StreamImpl("AABBABAC");
		assertEquals('B', firstChar(stream));
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveLancarIllegalArgumentExceptionQuandoNaoLocalizar() {
		Stream stream = new StreamImpl("a");
		firstChar(stream);
	}

	@Test
	public void deveRetornarLetraAEmMaiusculo() {
		Stream stream = new StreamImpl("  a");
		assertEquals('a', firstChar(stream));
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveLancarIllegalArgumentExceptionAoInformarNuloComoParametroStream() {
		Stream stream = new StreamImpl(null);
		firstChar(stream);
	}

}
