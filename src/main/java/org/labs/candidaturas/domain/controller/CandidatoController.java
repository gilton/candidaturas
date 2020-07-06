package org.labs.candidaturas.domain.controller;

import java.util.List;

import javax.validation.Valid;

import org.labs.candidaturas.domain.dto.MensagemResponseDTO;
import org.labs.candidaturas.domain.entity.Candidato;
import org.labs.candidaturas.domain.exception.CandidatoNotFoundExceptional;
import org.labs.candidaturas.domain.service.impl.CandidatoService;
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
@RequestMapping("/api/v1/candidatos")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CandidatoController {
	
	private CandidatoService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation("Adiciona um candidato")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Candidato adicionado com sucesso")})
	public MensagemResponseDTO inserir(@Valid @RequestBody Candidato candidato) {
		return service.inserir(candidato);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation("Altera um candidato")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Candidato alterado com sucesso")})
	public MensagemResponseDTO alterar(@PathVariable Long id, @Valid @RequestBody Candidato candidato) throws CandidatoNotFoundExceptional {
		return service.alterar(id, candidato);
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.GONE)
	@ApiOperation("Remove um candidato")
	@ApiResponses(value = {@ApiResponse(code = 410, message = "Candidato removido com sucesso")})
	public MensagemResponseDTO remover(@PathVariable Long id) throws CandidatoNotFoundExceptional {
		return service.remover(id);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation("Retorna um candidato")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Candidato encontrado com sucesso")})
	public Candidato findById(@PathVariable Long id) throws CandidatoNotFoundExceptional {
		return service.findById(id);
	}
	
	@GetMapping
	@ApiOperation("Retorna todos os candidatos")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Retorna todos os candidatos cadastrados")})
	public List<Candidato> findAll() {
		return service.findAll();
	}
	
}
