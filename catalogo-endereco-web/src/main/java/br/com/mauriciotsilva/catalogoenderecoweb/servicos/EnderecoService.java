package br.com.mauriciotsilva.catalogoenderecoweb.servicos;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;

import br.com.mauriciotsilva.catalogoenderecoweb.catalogo.Endereco;
import br.com.mauriciotsilva.catalogoenderecoweb.catalogo.repositorios.EnderecoRepositorio;

@Stateless
public class EnderecoService {

	@Inject
	private EnderecoRepositorio repositorio;

	public void incluir(@Valid Endereco endereco) {
		repositorio.incluir(endereco);
	}

	public Endereco alterar(@Valid Endereco endereco) {
		return repositorio.alterar(endereco);
	}

	public void deletar(String id) throws EnderecoNaoLocalizadoException {
		repositorio.deletar(consultar(id));
	}

	public Endereco consultar(String id) throws EnderecoNaoLocalizadoException {
		Endereco endereco = repositorio.consultar(id);
		if (endereco == null) {
			throw new EnderecoNaoLocalizadoException();
		}

		return endereco;
	}

}
