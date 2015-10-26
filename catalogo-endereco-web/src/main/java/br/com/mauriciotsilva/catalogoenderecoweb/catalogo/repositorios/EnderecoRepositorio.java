package br.com.mauriciotsilva.catalogoenderecoweb.catalogo.repositorios;

import java.util.Optional;

import br.com.mauriciotsilva.catalogoenderecoweb.catalogo.Endereco;

public interface EnderecoRepositorio {

	public Optional<Endereco> consultar(String id);

	public void incluir(Endereco endereco);

	public Endereco alterar(Endereco endereco);

	public void deletar(Endereco endereco);

}
