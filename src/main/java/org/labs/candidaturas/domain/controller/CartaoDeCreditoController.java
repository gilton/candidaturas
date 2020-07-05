package org.labs.candidaturas.domain.controller;

import java.util.List;

import org.labs.candidaturas.domain.dto.MensagemResponseDTO;
import org.labs.candidaturas.domain.entity.CartaoDeCredito;
import org.labs.candidaturas.domain.exception.CartaoDeCreditoNotFoundExceptional;
import org.labs.candidaturas.domain.service.impl.CartaoDeCreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/v1/cartoes")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CartaoDeCreditoController {
	
	private CartaoDeCreditoService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MensagemResponseDTO inserir(@RequestBody CartaoDeCredito cartaoDeCredito) {
		return service.inserir(cartaoDeCredito);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public MensagemResponseDTO alterar(@PathVariable Long id, @RequestBody CartaoDeCredito cartaoDeCredito) throws CartaoDeCreditoNotFoundExceptional {
		return service.alterar(id, cartaoDeCredito);
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.GONE)
	public MensagemResponseDTO remover(@PathVariable Long id) throws CartaoDeCreditoNotFoundExceptional {
		return service.remover(id);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public CartaoDeCredito findById(@PathVariable Long id) throws CartaoDeCreditoNotFoundExceptional {
		return service.findById(id);
	}
	
	@GetMapping
	public List<CartaoDeCredito> findAll() {
		return service.findAll();
	}
	
	
}
