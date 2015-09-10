package br.com.mauriciotsilva.catalogoenderecoweb.servicos;

import static javax.ws.rs.client.ClientBuilder.newClient;

import java.io.StringReader;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.validation.Valid;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.Response;

import br.com.mauriciotsilva.catalogoenderecoweb.catalogo.Endereco;
import br.com.mauriciotsilva.catalogoenderecoweb.catalogo.repositorios.EnderecoRepositorio;

@Stateless
public class EnderecoService {

	private final String linkConsulta = "http://localhost:8080/search-address/zip_code";

	@Inject
	private EnderecoRepositorio repositorio;

	public void incluir(@Valid Endereco endereco) {
		validarCep(endereco.getCep());
		repositorio.incluir(endereco);
	}

	public Endereco alterar(@Valid Endereco endereco) {
		validarCep(endereco.getCep());
		return repositorio.alterar(endereco);
	}

	private void validarCep(String cep) {
		try {
			newClient().target(linkConsulta).path(cep).request().buildGet().invoke(String.class);
		} catch (ClientErrorException e) {
			Response response = e.getResponse();

			JsonReader reader = Json.createReader(new StringReader(response.readEntity(String.class)));
			JsonObject json = reader.readObject();

			throw new ValidacaoCpfException(json.getString("mensagem"));
		}
	}

	public void deletar(String id) {
		repositorio.deletar(id);
	}

	public Endereco consultar(String id) {
		Endereco endereco = repositorio.consultar(id);
		if (endereco == null) {
			throw new EnderecoNaoLocalizadoException();
		}

		return endereco;
	}

}
