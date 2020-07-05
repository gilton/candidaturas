package org.labs.candidaturas.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNotFoundExceptional extends Exception {
	
	public UsuarioNotFoundExceptional(Long id) {
		super(String.format("Usuário de ID %s não encontrado!", id));
	}
}
