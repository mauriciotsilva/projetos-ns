package br.com.mauriciotsilva.consultaendereco.resources;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mauriciotsilva.consultaendereco.logradouro.Endereco;
import br.com.mauriciotsilva.consultaendereco.servicos.EnderecoService;

@RestController
@RequestMapping("/search-address/zip_code")
public class EnderecoController {

	@Autowired
	private EnderecoService servico;

	@RequestMapping(value = "/{zip_code}", method = GET, produces = "application/json")
	public Endereco buscarPorCep(@PathVariable(value = "zip_code") String cep) throws Exception {
		return servico.buscarPorCep(cep);
	}

}
