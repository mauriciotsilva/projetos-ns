package br.com.mauriciotsilva.catalogoenderecoweb.produtores;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Fabrica {

	@Produces
	public EntityManager criarEntityManager() {
		return Persistence.createEntityManagerFactory("").createEntityManager();
	}

}
