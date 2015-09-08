package br.com.mauriciotsilva;

import static java.lang.Character.toUpperCase;

import java.util.HashSet;
import java.util.Set;

import br.com.mauriciotsilva.stream.Stream;
import br.com.mauriciotsilva.stream.StreamImpl;

public class App {

	public static void main(String... args) {

		Stream stream = new StreamImpl("Aac");
		System.out.println(firstChar(stream));

	}

	public static char firstChar(Stream stream) {

		Set<Character> caracteres = new HashSet<>();

		while (stream.hasNext()) {
			char caractere = stream.getNext();
			char maiusculo = toUpperCase(caractere);

			if (!caracteres.isEmpty() & caracteres.add(maiusculo)) {
				return caractere;
			}
		}

		throw new IllegalArgumentException(
				"Não foi possível localizar uma sequência para o texto informado");
	}
}
