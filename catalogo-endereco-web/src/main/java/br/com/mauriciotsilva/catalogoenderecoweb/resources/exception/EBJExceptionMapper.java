package br.com.mauriciotsilva.catalogoenderecoweb.resources.exception;

import static javax.ws.rs.core.Response.serverError;
import static javax.ws.rs.core.Response.status;

import javax.ejb.EJBException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class EBJExceptionMapper implements ExceptionMapper<EJBException> {

	@Override
	public Response toResponse(EJBException exception) {

		Throwable causa = exception.getCause();
		if (causa != null) {
			return status(400).entity(new Erro(causa.getMessage())).build();
		}

		return serverError().entity(new Erro(exception)).build();
	}

}
