package br.com.mauriciotsilva;

import java.util.HashSet;
import java.util.Set;

import br.com.mauriciotsilva.stream.Stream;
import br.com.mauriciotsilva.stream.StreamImpl;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {

		Stream stream = new StreamImpl("aAbBABac");
		System.out.println(firstChar(stream));

	}

	public static char firstChar(Stream stream) {

		Set<Character> chars = new HashSet<Character>();

		while (stream.hasNext()) {
			Character character = stream.getNext();
			Character convertido = Character.toUpperCase(character);

			if (!chars.isEmpty() & chars.add(convertido)) {
				return character;
			}
		}

		return '\u0000';
	}
}
