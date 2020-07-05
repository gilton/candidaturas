package org.labs.candidaturas.domain.controller;

import java.util.List;

import org.labs.candidaturas.domain.entity.Candidato;
import org.labs.candidaturas.domain.service.impl.CandidatoService;
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
@RequestMapping("/candidato")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CandidatoController {
	
	private CandidatoService service;

	@PostMapping
	public String inserir(@RequestBody Candidato candidato) {
		return service.inserir(candidato);
	}

	@PutMapping("/{id}")
	public String alterar(@PathVariable Long id, @RequestBody Candidato candidato) {
		return service.alterar(id, candidato);
	}

	@DeleteMapping("{id}")
	public String remover(@PathVariable Long id) {
		return service.remover(id);
	}

	
	@GetMapping("/{id}")
	public Candidato findById(@PathVariable Long id) {
		return service.findById(id);
	}

	
	@GetMapping
	public List<Candidato> findAll() {
		return service.findAll();
	}
	
	
	
}
