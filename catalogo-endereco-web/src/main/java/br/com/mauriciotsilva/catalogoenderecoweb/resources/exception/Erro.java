package br.com.mauriciotsilva.catalogoenderecoweb.resources.exception;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Erro {

	@XmlElement(name = "message")
	private String mensagem;

	protected Erro() {
	}

	public Erro(String mensagem) {
		this();
		this.mensagem = mensagem;
	}

	public Erro(Throwable throwable) {
		this(throwable.getMessage());
	}

	protected String getMensagem() {
		return mensagem;
	}

	protected void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
