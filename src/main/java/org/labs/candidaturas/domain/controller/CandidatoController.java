package org.labs.candidaturas.domain.controller;

import java.util.List;

import javax.validation.Valid;

import org.labs.candidaturas.domain.dto.MensagemResponseDTO;
import org.labs.candidaturas.domain.entity.Candidato;
import org.labs.candidaturas.domain.exception.CandidatoNotFoundExceptional;
import org.labs.candidaturas.domain.service.impl.CandidatoService;
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
@RequestMapping("/api/v1/candidato")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CandidatoController {
	
	private CandidatoService service;

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	@ApiOperation("Adiciona um candidato")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Candidato adicionado com sucesso")})
	public MensagemResponseDTO inserir(@Valid @RequestBody Candidato candidato) {
		return service.inserir(candidato);
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
	@ApiOperation("Altera um candidato")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Candidato alterado com sucesso")})
	public MensagemResponseDTO alterar(@PathVariable Long id, @Valid @RequestBody Candidato candidato) throws CandidatoNotFoundExceptional {
		return service.alterar(id, candidato);
	}


	@ResponseStatus(HttpStatus.GONE)
	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	@ApiOperation("Remove um candidato")
	@ApiResponses(value = {@ApiResponse(code = 410, message = "Candidato removido com sucesso")})
	public MensagemResponseDTO remover(@PathVariable Long id) throws CandidatoNotFoundExceptional {
		return service.remover(id);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(path = "/find/{id}", method = RequestMethod.GET)
	@ApiOperation("Retorna um candidato")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Candidato encontrado com sucesso")})
	public Candidato findById(@PathVariable Long id) throws CandidatoNotFoundExceptional {
		return service.findById(id);
	}
	
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	@ApiOperation("Retorna todos os candidatos")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Retorna todos os candidatos cadastrados")})
	public List<Candidato> findAll() {
		return service.findAll();
	}
	
}
