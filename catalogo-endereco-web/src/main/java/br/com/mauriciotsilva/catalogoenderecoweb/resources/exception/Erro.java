package br.com.mauriciotsilva.catalogoenderecoweb.resources.exception;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Erro {

	@XmlAttribute(name = "mensagens")
	@XmlElementWrapper(name = "mensagem")
	private List<MensagemErro> mensagens;

	public Erro() {
		this.mensagens = new ArrayList<>();
	}

	public Erro(MensagemErro mensagemErro) {
		this();
		adicionarMensagem(mensagemErro);
	}

	public void adicionarMensagens(Collection<MensagemErro> mensagens) {
		this.mensagens.addAll(mensagens);
	}

	public void adicionarMensagem(MensagemErro mensagem) {
		mensagens.add(mensagem);
	}

	protected List<MensagemErro> getMensagens() {
		return mensagens;
	}

}
