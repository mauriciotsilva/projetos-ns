package br.com.mauriciotsilva.consultaendereco.resources.handlers;

public class Erro {

	private String mensagem;

	public Erro(String mensagem) {
		this.mensagem = mensagem;
	}

	public Erro(Throwable throwable) {
		this(throwable.getMessage());
	}

	public String getMensagem() {
		return mensagem;
	}

}
