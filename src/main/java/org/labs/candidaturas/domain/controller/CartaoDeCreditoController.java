package org.labs.candidaturas.domain.controller;

import java.util.List;

import org.labs.candidaturas.domain.entity.CartaoDeCredito;
import org.labs.candidaturas.domain.service.impl.CartaoDeCreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/cartao")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CartaoDeCreditoController {
	
	private CartaoDeCreditoService service;

	@PostMapping
	public String inserir(@RequestBody CartaoDeCredito cartaoDeCredito) {
		return service.inserir(cartaoDeCredito);
	}

	@PutMapping("/{id}")
	public String alterar(@PathVariable Long id, @RequestBody CartaoDeCredito cartaoDeCredito) {
		return service.alterar(id, cartaoDeCredito);
	}

	@DeleteMapping("{id}")
	public String remover(@PathVariable Long id) {
		return service.remover(id);
	}

	
	@GetMapping("/{id}")
	public CartaoDeCredito findById(@PathVariable Long id) {
		return service.findById(id);
	}

	
	@GetMapping
	public List<CartaoDeCredito> findAll() {
		return service.findAll();
	}
	
	
	
}
