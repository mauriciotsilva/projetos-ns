package br.com.mauriciotsilva.consultaendereco.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mauriciotsilva.consultaendereco.logradouro.Cep;
import br.com.mauriciotsilva.consultaendereco.logradouro.Endereco;
import br.com.mauriciotsilva.consultaendereco.respotorios.logradouro.EnderecoRepositorio;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepositorio repositorio;

	public Endereco buscarPorCep(String numeroCep) throws CepNaoLocalizadoException {

		Endereco endereco = pesquisarPorCep(new Cep(numeroCep));
		if (endereco == null) {
			throw new CepNaoLocalizadoException();
		}

		return endereco;
	}

	private Endereco pesquisarPorCep(Cep cep) {

		Endereco endereco = null;
		StringBuilder builder = new StringBuilder(cep.getNumero());

		while (true) {
			endereco = repositorio.buscarPorCep(new Cep(builder));
			if (endereco != null || builder.length() == 0) {
				break;
			}
			builder.deleteCharAt(builder.length() - 1);
		}

		return endereco;
	}
}
