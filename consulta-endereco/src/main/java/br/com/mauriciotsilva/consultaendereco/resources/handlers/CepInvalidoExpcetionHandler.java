package br.com.mauriciotsilva.consultaendereco.resources.handlers;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.ResponseEntity.status;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.mauriciotsilva.consultaendereco.logradouro.CepInvalidoExpcetion;

@ControllerAdvice
public class CepInvalidoExpcetionHandler {

	@ExceptionHandler(CepInvalidoExpcetion.class)
	public ResponseEntity<?> teste(CepInvalidoExpcetion e) {
		return status(BAD_REQUEST).body(new Erro(e));
	}

}
