package org.labs.candidaturas.domain.controller;

import java.util.List;

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

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/v1/candidatos")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CandidatoController {
	
	private CandidatoService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MensagemResponseDTO inserir(@RequestBody Candidato candidato) {
		return service.inserir(candidato);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public MensagemResponseDTO alterar(@PathVariable Long id, @RequestBody Candidato candidato) throws CandidatoNotFoundExceptional {
		return service.alterar(id, candidato);
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.GONE)
	public MensagemResponseDTO remover(@PathVariable Long id) throws CandidatoNotFoundExceptional {
		return service.remover(id);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Candidato findById(@PathVariable Long id) throws CandidatoNotFoundExceptional {
		return service.findById(id);
	}
	
	@GetMapping
	public List<Candidato> findAll() {
		return service.findAll();
	}
	
}
