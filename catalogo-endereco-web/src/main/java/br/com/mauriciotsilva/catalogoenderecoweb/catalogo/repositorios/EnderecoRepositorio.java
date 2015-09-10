package br.com.mauriciotsilva.catalogoenderecoweb.catalogo.repositorios;

import br.com.mauriciotsilva.catalogoenderecoweb.catalogo.Endereco;

public interface EnderecoRepositorio {

	public void incluir(Endereco endereco);

	public Endereco consultar(String id);

	public Endereco alterar(Endereco endereco);

	public void deletar(String id);

}
