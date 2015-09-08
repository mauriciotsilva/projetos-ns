package br.com.mauriciotsilva;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

	public static char firstCharFlavio(Stream stream) {
		int index = 0;
		char current;
		char nextChar = 0;
		char foundRepeated = 0;
		char found = 0;

		while (stream.hasNext()) {
			current = stream.getNext();
			nextChar = stream.getNext();

			if (foundRepeated != 0
					&& Character.toUpperCase(foundRepeated) != Character
							.toUpperCase(nextChar)) {
				found = nextChar;
				break;
			}

			if (Character.toUpperCase(current) == Character
					.toUpperCase(nextChar)) {
				foundRepeated = current;
			}

			index++;
		}

		if (found == 0)
			System.out.println("Exception");
		return found;
	}

	public static char firstCharJamal(Stream stream) {

		List<Character> texto = new ArrayList<Character>();
		List<Character> repetidas = new ArrayList<Character>();

		Character character = null;
		while (stream.hasNext()) {
			character = stream.getNext();

			if (texto.contains(character)) {
				repetidas.add(character);
			}

			texto.add(character);

		}

		System.out.println(repetidas);

		return ' ';
	}
}
