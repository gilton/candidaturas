package org.labs.candidaturas.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CandidatoNotFoundExceptional extends Exception {
	
	public CandidatoNotFoundExceptional(Long id) {
		super(String.format("Candidato de ID %s não encontrado!", id));
	}
	
}
