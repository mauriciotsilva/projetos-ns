package br.com.mauriciotsilva.stream;

public class StreamImpl implements Stream {

	private int index;
	private CharSequence texto;

	public StreamImpl(CharSequence texto) {
		if (texto == null) {
			texto = new StringBuilder();
		}
		this.texto = texto;
	}

	public char getNext() {
		return texto.charAt(index++);
	}

	public boolean hasNext() {
		return index < texto.length();
	}

}
