package org.labs.candidaturas.domain.controller;

import java.util.List;

import javax.validation.Valid;

import org.labs.candidaturas.domain.dto.MensagemResponseDTO;
import org.labs.candidaturas.domain.entity.Usuario;
import org.labs.candidaturas.domain.exception.UsuarioNotFoundExceptional;
import org.labs.candidaturas.domain.service.impl.UsuarioService;
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
@RequestMapping("/api/v1/usuario")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioController {
	
	private UsuarioService service;

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Usuário adicionado com sucesso")})
	@ApiOperation("Adiciona um usuário")
	public MensagemResponseDTO inserir(@Valid @RequestBody Usuario user) {
		return service.inserir(user);
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Usuário alterado com sucesso")})
	@ApiOperation("Altera um usuário")
	public MensagemResponseDTO alterar(@PathVariable Long id, @Valid @RequestBody Usuario user) throws UsuarioNotFoundExceptional {
		return service.alterar(id, user);
	}

	@ResponseStatus(HttpStatus.GONE)
	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	@ApiResponses(value = {@ApiResponse(code = 410, message = "Usuário removido com sucesso")})
	@ApiOperation("Remove um usuário")
	public MensagemResponseDTO remover(@PathVariable Long id) throws UsuarioNotFoundExceptional {
		return service.remover(id);
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(path = "/find/{id}", method = RequestMethod.GET)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Usuário encontrado com sucesso")})
	@ApiOperation("Retorna um usuário")
	public Usuario findById(@PathVariable Long id) throws UsuarioNotFoundExceptional {
		return service.findById(id);
	}
	
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Candidatos encontrados com sucesso")})
	@ApiOperation("Retorna todos os usuários")
	public List<Usuario> findAll() {
		return service.findAll();
	}
	
	
}
