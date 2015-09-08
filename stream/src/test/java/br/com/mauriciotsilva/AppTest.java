package br.com.mauriciotsilva;

import static br.com.mauriciotsilva.App.firstChar;
import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import br.com.mauriciotsilva.stream.Stream;

public class AppTest {

	@Test
	public void deveRetornarLetraBEmMinusculo() {
		Stream stream = Stream.from("aAbBABac");
		assertEquals('b', firstChar(stream));
	}

	@Test
	public void deveRetornarLetraBEmMaiusculo() {
		Stream stream = Stream.from("AABBABAC");
		assertEquals('B', firstChar(stream));
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveLancarIllegalArgumentExceptionQuandoNaoLocalizar() {
		Stream stream = Stream.from("a");
		firstChar(stream);
	}

	@Test
	public void deveRetornarLetraAEmMaiusculo() {
		Stream stream = Stream.from("  a");
		assertEquals('a', firstChar(stream));
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveLancarIllegalArgumentExceptionAoInformarNuloComoParametroStream() {
		Stream stream = Stream.from(null);
		firstChar(stream);
	}

}
