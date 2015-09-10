package br.com.mauriciotsilva.catalogoenderecoweb.resources.exception;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class MensagemErro {

	private String propriedade;
	private String mensagem;

	public MensagemErro(Throwable expcetion) {
		this(expcetion.getMessage());
	}

	public MensagemErro(String mensagem) {
		this(null, mensagem);
	}

	public MensagemErro(String propriedade, String mensagem) {
		this.propriedade = propriedade;
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getPropriedade() {
		return propriedade;
	}

}
