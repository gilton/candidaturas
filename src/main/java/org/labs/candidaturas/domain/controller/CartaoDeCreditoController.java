package org.labs.candidaturas.domain.controller;

import java.util.List;

import javax.validation.Valid;

import org.labs.candidaturas.domain.dto.MensagemResponseDTO;
import org.labs.candidaturas.domain.entity.CartaoDeCredito;
import org.labs.candidaturas.domain.exception.CartaoDeCreditoNotFoundExceptional;
import org.labs.candidaturas.domain.service.impl.CartaoDeCreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/v1/cartao")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CartaoDeCreditoController {
	
	private CartaoDeCreditoService service;
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Cartão de crédito adicionado com sucesso")})
	@ApiOperation("Adiciona um cartão de crédito")
	public MensagemResponseDTO inserir(@Valid @RequestBody CartaoDeCredito cartaoDeCredito) {
		return service.inserir(cartaoDeCredito);
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Cartão de crédito alterado com sucesso")})
	@ApiOperation("Altera um cartão de crédito")
	public MensagemResponseDTO alterar(@PathVariable Long id, @Valid @RequestBody CartaoDeCredito cartaoDeCredito) throws CartaoDeCreditoNotFoundExceptional {
		return service.alterar(id, cartaoDeCredito);
	}

	@ResponseStatus(HttpStatus.GONE)
	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	@ApiResponses(value = {@ApiResponse(code = 410, message = "Cartão de crédito removido com sucesso")})
	@ApiOperation("Remover um cartão de crédito")
	public MensagemResponseDTO remover(@PathVariable Long id) throws CartaoDeCreditoNotFoundExceptional {
		return service.remover(id);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(path = "/find/{id}", method = RequestMethod.GET)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Cartão de crédito encontrado com sucesso")})
	@ApiOperation("Retorna um cartão de crédito")
	public CartaoDeCredito findById(@PathVariable Long id) throws CartaoDeCreditoNotFoundExceptional {
		return service.findById(id);
	}
	
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Cartões de créditos encontrados com sucesso")})
	@ApiOperation("Retorna todos os cartões de créditos")
	public List<CartaoDeCredito> findAll() {
		return service.findAll();
	}
	
	
}
