package org.labs.candidaturas.domain.controller;

import java.util.List;

import org.labs.candidaturas.domain.entity.Usuario;
import org.labs.candidaturas.domain.service.impl.UsuarioService;
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
@RequestMapping("/api/v1/usuarios")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioController {
	
	private UsuarioService service;

	@PostMapping
	public String inserir(@RequestBody Usuario user) {
		return service.inserir(user);
	}

	@PutMapping("/{id}")
	public String alterar(@PathVariable Long id, @RequestBody Usuario user) {
		return service.alterar(id, user);
	}

	@DeleteMapping("{id}")
	public String remover(@PathVariable Long id) {
		return service.remover(id);
	}

	@GetMapping("/{id}")
	public Usuario findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@GetMapping
	public List<Usuario> findAll() {
		return service.findAll();
	}
	
	
}
