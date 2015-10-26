package br.com.mauriciotsilva.catalogoenderecoweb.servicos;

public class EnderecoNaoLocalizadoException extends Exception {

	private static final long serialVersionUID = 7008892828134649808L;

	public static final String MENSAGEM = "Endereço não Localizado";

	public EnderecoNaoLocalizadoException(Throwable causa) {
		this(MENSAGEM, causa);
	}

	protected EnderecoNaoLocalizadoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
