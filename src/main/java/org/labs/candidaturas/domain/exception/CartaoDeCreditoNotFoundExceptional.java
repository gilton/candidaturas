package org.labs.candidaturas.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CartaoDeCreditoNotFoundExceptional extends Exception {
	
	public CartaoDeCreditoNotFoundExceptional(Long id) {
		super(String.format("Cartão de Crédito de ID %s não encontrado!", id));
	}
}
