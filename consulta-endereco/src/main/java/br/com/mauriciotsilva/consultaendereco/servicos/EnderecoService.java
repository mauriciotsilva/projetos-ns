package br.com.mauriciotsilva.consultaendereco.servicos;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mauriciotsilva.consultaendereco.logradouro.Cep;
import br.com.mauriciotsilva.consultaendereco.logradouro.Endereco;
import br.com.mauriciotsilva.consultaendereco.respotorios.logradouro.EnderecoRepositorio;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepositorio repositorio;

	public Endereco buscarPorCep(String cep) throws CepNaoLocalizadoException {

		try {

			StringBuilder numeroCep = new StringBuilder(cep);
			Optional<Endereco> endereco = buscarEnderecoPeloCepGenerico(numeroCep);
			return endereco.get();

		} catch (NoSuchElementException e) {
			throw new CepNaoLocalizadoException();
		}
	}

	private Optional<Endereco> buscarEnderecoPeloCepGenerico(StringBuilder builder) {
		Optional<Endereco> endereco = repositorio.buscarPorCep(new Cep(builder));
		if (!endereco.isPresent() && builder.length() > 0) {
			buscarEnderecoPeloCepGenerico(builder.deleteCharAt(builder.length() - 1));
		}

		return endereco;
	}

}
