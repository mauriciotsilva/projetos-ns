package br.com.mauriciotsilva.catalogoenderecoweb.servicos;

public class EnderecoNaoLocalizadoException extends Exception {

	private static final long serialVersionUID = 7008892828134649808L;

	public EnderecoNaoLocalizadoException() {
		super("Endereço não Localizado");
	}

}
