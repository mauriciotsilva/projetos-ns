package br.com.mauriciotsilva.catalogoenderecoweb.catalogo.repositorios;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.mauriciotsilva.catalogoenderecoweb.catalogo.Endereco;

@Alternative
public class EnderecoJpaRepositorio implements EnderecoRepositorio {

	private EntityManager em;

	@Inject
	public EnderecoJpaRepositorio(EntityManager em) {
		this.em = em;
	}

	@Override
	public void incluir(Endereco endereco) {
		em.persist(endereco);
	}

	@Override
	public Endereco consultar(String id) {
		return em.find(Endereco.class, id);
	}

	@Override
	public Endereco alterar(Endereco endereco) {
		return em.merge(endereco);
	}

	@Override
	public void deletar(Endereco endereco) {
		em.remove(endereco);
	}

}
