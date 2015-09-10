package br.com.mauriciotsilva.catalogoenderecoweb.resources.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.mauriciotsilva.catalogoenderecoweb.servicos.EnderecoNaoLocalizadoException;

@Provider
public class EnderecoNaoLocalizadoExceptionMapper implements ExceptionMapper<EnderecoNaoLocalizadoException> {

	@Override
	public Response toResponse(EnderecoNaoLocalizadoException exception) {
		return Response.status(404).entity(new Erro(new MensagemErro(exception))).build();
	}

}
