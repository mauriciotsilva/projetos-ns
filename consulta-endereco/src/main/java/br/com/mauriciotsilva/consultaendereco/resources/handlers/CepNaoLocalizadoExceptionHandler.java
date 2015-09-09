package br.com.mauriciotsilva.consultaendereco.resources.handlers;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.ResponseEntity.status;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.mauriciotsilva.consultaendereco.servicos.CepNaoLocalizadoException;

@ControllerAdvice
public class CepNaoLocalizadoExceptionHandler {

	@ExceptionHandler(CepNaoLocalizadoException.class)
	public ResponseEntity<?> handler(CepNaoLocalizadoException e) {
		return status(NOT_FOUND).body(new Erro(e));
	}
}
