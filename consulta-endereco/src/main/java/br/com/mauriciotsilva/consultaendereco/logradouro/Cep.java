package br.com.mauriciotsilva.consultaendereco.logradouro;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Cep {

	public static final int TAMANHO = 8;

	@JsonProperty("code")
	private String numero;

	@JsonCreator
	public Cep(@JsonProperty("code") CharSequence numero) {
		this.numero = completarComZeroADireita(numero);
		validar();
	}

	private void validar() {
		if (numero.length() != TAMANHO || !numero.matches("\\d+")) {
			throw new CepInvalidoExpcetion();
		}
	}

	private String completarComZeroADireita(CharSequence numero) {

		int tamanho = TAMANHO - numero.length();
		StringBuilder builder = new StringBuilder(numero);
		for (int i = 0; i < tamanho; i++) {
			builder.append('0');
		}

		return builder.toString();
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Cep other = (Cep) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

}
