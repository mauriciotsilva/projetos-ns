package br.com.mauriciotsilva.consultaendereco.respotorios.logradouro;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.mauriciotsilva.consultaendereco.logradouro.Cep;
import br.com.mauriciotsilva.consultaendereco.logradouro.Endereco;

@Repository
public class EnderecoRepositorio {

	public Endereco buscarPorCep(Cep cep) {
		List<Endereco> enderecos = Arrays.asList(lerEndecosArquivoJson());
		return enderecos.stream().filter(endereco -> cep.equals(endereco.getCep())).findFirst().orElse(null);
	}

	private Endereco[] lerEndecosArquivoJson() {

		try (InputStream inputStream = getClass().getResourceAsStream("/enderecos.json")) {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(inputStream, Endereco[].class);
		} catch (Exception e) {
			throw new RuntimeException("Não foi possivel ler arquivo json", e);
		}
	}

}
