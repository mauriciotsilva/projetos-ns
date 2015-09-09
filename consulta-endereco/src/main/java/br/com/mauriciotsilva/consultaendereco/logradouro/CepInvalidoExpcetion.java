package br.com.mauriciotsilva.consultaendereco.logradouro;

public class CepInvalidoExpcetion extends IllegalArgumentException {

	private static final long serialVersionUID = -5263960263075035468L;

	public CepInvalidoExpcetion() {
		super("CEP inválido");
	}

}
