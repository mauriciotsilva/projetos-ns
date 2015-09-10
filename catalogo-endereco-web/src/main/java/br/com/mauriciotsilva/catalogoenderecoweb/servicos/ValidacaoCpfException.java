package br.com.mauriciotsilva.catalogoenderecoweb.servicos;

public class ValidacaoCpfException extends IllegalArgumentException {

	private static final long serialVersionUID = -8359697083735386469L;

	public ValidacaoCpfException(String mensagem) {
		super(mensagem);
	}
}
