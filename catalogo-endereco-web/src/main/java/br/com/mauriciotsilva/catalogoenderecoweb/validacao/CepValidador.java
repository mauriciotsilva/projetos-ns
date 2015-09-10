package br.com.mauriciotsilva.catalogoenderecoweb.validacao;

import static javax.ws.rs.client.ClientBuilder.newClient;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.Response;

public class CepValidador implements ConstraintValidator<Cep, String> {

	private final String linkConsulta = "http://localhost:8080/search-address/zip_code";

	@Override
	public void initialize(Cep cep) {
	}

	@Override
	public boolean isValid(String numeroCep, ConstraintValidatorContext context) {

		boolean ehValido = false;

		try {
			if (numeroCep != null) {
				newClient().target(linkConsulta).path(numeroCep).request().buildGet().invoke(String.class);
			}

			ehValido = true;
		} catch (ClientErrorException e) {

			JsonObject json = lerPayload(e.getResponse());

			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(getMensagem(json)).addConstraintViolation();

		}

		return ehValido;
	}

	private String getMensagem(JsonObject json) {

		String mensagem = "";
		if (json.containsKey("error")) {
			mensagem = json.getString("error");
		}

		return json.getString("mensagem", mensagem);
	}

	private JsonObject lerPayload(Response response) {

		try (StringReader reader = new StringReader(response.readEntity(String.class));
				JsonReader jsonReader = Json.createReader(reader)) {
			return jsonReader.readObject();
		}

	}

}
