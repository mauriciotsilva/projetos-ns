package br.com.mauriciotsilva.catalogoenderecoweb.resources;

import static javax.ws.rs.core.Link.fromMethod;
import static javax.ws.rs.core.Response.created;
import static javax.ws.rs.core.Response.noContent;
import static javax.ws.rs.core.Response.ok;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.mauriciotsilva.catalogoenderecoweb.catalogo.Endereco;
import br.com.mauriciotsilva.catalogoenderecoweb.servicos.EnderecoService;

@Path("/addresses")
@Consumes("application/json")
@Produces("application/json")
public class EnderecoResource {

	@Inject
	private EnderecoService servico;

	@POST
	public Response incluir(Endereco endereco) {

		servico.incluir(endereco);
		return created(fromMethod(EnderecoResource.class, "consultar").build(endereco.getId()).getUri())
				.entity(endereco).build();
	}

	@GET
	@Path("/{id}")
	public Response consultar(@PathParam("id") String id) {
		return ok(servico.consultar(id)).build();
	}

	@PUT
	@Path("/{id}")
	public Response atualizar(@PathParam("id") String id, Endereco endereco) {
		return ok(servico.alterar(endereco)).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deletar(@PathParam("id") String id) {
		servico.deletar(id);
		return noContent().build();
	}

}
