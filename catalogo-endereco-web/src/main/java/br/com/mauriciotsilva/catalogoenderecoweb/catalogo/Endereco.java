package br.com.mauriciotsilva.catalogoenderecoweb.catalogo;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import br.com.mauriciotsilva.catalogoenderecoweb.validacao.Cep;

@Entity
@Table(name = "endereco")
@XmlAccessorType(XmlAccessType.FIELD)
public class Endereco {

	@Id
	@SequenceGenerator(name = "seq_endereco", sequenceName = "seq_endereco")
	@GeneratedValue(generator = "seq_endereco", strategy = GenerationType.SEQUENCE)
	private String id;

	@NotNull
	private String rua;

	@NotNull
	private String numero;

	private String bairro;

	@NotNull
	private String cidade;

	@NotNull
	private String estado;

	@Cep
	private String cep;

	private String complemento;

	protected Endereco() {
		this.id = UUID.randomUUID().toString();
	}

	public Endereco(String id) {
		this();
		this.id = id;
	}

	protected String getRua() {
		return rua;
	}

	protected void setRua(String rua) {
		this.rua = rua;
	}

	protected String getBairro() {
		return bairro;
	}

	protected void setBairro(String bairro) {
		this.bairro = bairro;
	}

	protected String getCidade() {
		return cidade;
	}

	protected void setCidade(String cidade) {
		this.cidade = cidade;
	}

	protected String getEstado() {
		return estado;
	}

	protected void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	protected void setCep(String cep) {
		this.cep = cep;
	}

	public String getId() {
		return id;
	}

	protected void setId(String id) {
		this.id = id;
	}

	protected String getNumero() {
		return numero;
	}

	protected void setNumero(String numero) {
		this.numero = numero;
	}

	protected String getComplemento() {
		return complemento;
	}

	protected void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
