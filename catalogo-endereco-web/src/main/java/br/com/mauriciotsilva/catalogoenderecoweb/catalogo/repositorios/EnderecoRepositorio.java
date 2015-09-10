package br.com.mauriciotsilva.catalogoenderecoweb.catalogo.repositorios;

import br.com.mauriciotsilva.catalogoenderecoweb.catalogo.Endereco;

public interface EnderecoRepositorio {

	public Endereco consultar(String id);

	public void incluir(Endereco endereco);

	public Endereco alterar(Endereco endereco);

	public void deletar(Endereco endereco);

}
