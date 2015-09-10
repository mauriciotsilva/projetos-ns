package br.com.mauriciotsilva.catalogoenderecoweb.catalogo.repositorios;

import java.util.ArrayList;
import java.util.List;

import br.com.mauriciotsilva.catalogoenderecoweb.catalogo.Endereco;

public class EnderecoEstaticoRepositorio implements EnderecoRepositorio {

	private static final List<Endereco> enderecos;

	static {
		enderecos = new ArrayList<>();
	}

	@Override
	public void incluir(Endereco endereco) {
		enderecos.add(endereco);
	}

	@Override
	public Endereco consultar(String id) {
		return enderecos.stream().filter(endereco -> id.equals(endereco.getId())).findFirst().orElse(null);
	}

	@Override
	public Endereco alterar(Endereco endereco) {

		int index = enderecos.indexOf(endereco);
		if (index < 0) {
			enderecos.add(endereco);
		} else {
			enderecos.set(index, endereco);
		}

		return endereco;
	}

	@Override
	public void deletar(Endereco endereco) {
		enderecos.remove(endereco);
	}

}
