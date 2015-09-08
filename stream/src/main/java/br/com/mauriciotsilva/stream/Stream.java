package br.com.mauriciotsilva.stream;

public interface Stream {

	public char getNext();

	public boolean hasNext();

	public static Stream from(CharSequence texto) {
		return new StreamImpl(texto);
	}

}
