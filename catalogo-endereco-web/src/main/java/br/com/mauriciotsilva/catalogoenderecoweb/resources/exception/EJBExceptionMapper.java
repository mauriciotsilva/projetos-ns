package br.com.mauriciotsilva.catalogoenderecoweb.resources.exception;

import static java.util.stream.Collectors.toList;
import static javax.ws.rs.core.Response.serverError;
import static javax.ws.rs.core.Response.status;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.ejb.EJBException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path.Node;
import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class EJBExceptionMapper implements ExceptionMapper<EJBException> {

	@Override
	public Response toResponse(EJBException exception) {

		Erro erro = new Erro();
		Throwable causa = exception.getCause();

		if (causa != null) {
			if (causa instanceof ConstraintViolationException) {
				List<MensagemErro> mensagens = extrairMensagensErroApartir((ConstraintViolationException) causa);
				erro.adicionarMensagens(mensagens);
			} else if (causa instanceof ValidationException) {
				erro.adicionarMensagem(new MensagemErro("Não foi possível validar"));
			}

			return status(400).entity(erro).build();
		}

		erro.adicionarMensagem(new MensagemErro(exception));
		return serverError().entity(erro).build();
	}

	private List<MensagemErro> extrairMensagensErroApartir(ConstraintViolationException exception) {

		Set<ConstraintViolation<?>> constraints = exception.getConstraintViolations();
		return constraints.stream().map(this::converter).collect(toList());

	}

	private MensagemErro converter(ConstraintViolation<?> contraintViolation) {

		Iterator<Node> nodes = contraintViolation.getPropertyPath().iterator();
		Node node = null;
		while (nodes.hasNext()) {
			node = nodes.next();
		}

		return new MensagemErro(node.getName(), contraintViolation.getMessage());
	}

}
