package br.com.mauriciotsilva.catalogoenderecoweb.catalogo.repositorios;

import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.mauriciotsilva.catalogoenderecoweb.catalogo.Endereco;

public class EnderecoJpaRepositorio implements EnderecoRepositorio {

	private EntityManager entityManager;

	@Inject
	public EnderecoJpaRepositorio(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void incluir(Endereco endereco) {
		entityManager.persist(endereco);
	}

	@Override
	public Optional<Endereco> consultar(String id) {
		Endereco endereco = entityManager.find(Endereco.class, id);
		return Optional.ofNullable(endereco);
	}

	@Override
	public Endereco alterar(Endereco endereco) {
		return entityManager.merge(endereco);
	}

	@Override
	public void deletar(Endereco endereco) {
		entityManager.remove(endereco);
	}

}
