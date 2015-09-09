package br.com.mauriciotsilva.consultaendereco.servicos;

public class CepNaoLocalizadoException extends Exception {

	private static final long serialVersionUID = 4330226487642019818L;

	public CepNaoLocalizadoException() {
		super("CEP não localizado");
	}

}
