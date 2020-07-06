package org.labs.candidaturas.domain.controller;

import java.util.List;

import javax.validation.Valid;

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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/v1/cartoes")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CartaoDeCreditoController {
	
	private CartaoDeCreditoService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation("Adiciona um cartão de crédito")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Cartão de crédito adicionado com sucesso")})
	public MensagemResponseDTO inserir(@Valid @RequestBody CartaoDeCredito cartaoDeCredito) {
		return service.inserir(cartaoDeCredito);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation("Altera um cartão de crédito")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Cartão de crédito alterado com sucesso")})
	public MensagemResponseDTO alterar(@PathVariable Long id, @Valid @RequestBody CartaoDeCredito cartaoDeCredito) throws CartaoDeCreditoNotFoundExceptional {
		return service.alterar(id, cartaoDeCredito);
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.GONE)
	@ApiOperation("Remover um cartão de crédito")
	@ApiResponses(value = {@ApiResponse(code = 410, message = "Cartão de crédito removido com sucesso")})
	public MensagemResponseDTO remover(@PathVariable Long id) throws CartaoDeCreditoNotFoundExceptional {
		return service.remover(id);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation("Retorna um cartão de crédito")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Cartão de crédito encontrado com sucesso")})
	public CartaoDeCredito findById(@PathVariable Long id) throws CartaoDeCreditoNotFoundExceptional {
		return service.findById(id);
	}
	
	@GetMapping
	@ApiOperation("Retorna todos os cartões de créditos")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Cartões de créditos encontrados com sucesso")})
	public List<CartaoDeCredito> findAll() {
		return service.findAll();
	}
	
	
}
