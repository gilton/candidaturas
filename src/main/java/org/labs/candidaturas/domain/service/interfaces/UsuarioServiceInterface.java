package org.labs.candidaturas.domain.service.interfaces;

import java.util.List;

import org.labs.candidaturas.domain.dto.MensagemResponseDTO;
import org.labs.candidaturas.domain.entity.Usuario;
import org.labs.candidaturas.domain.exception.UsuarioNotFoundExceptional;

public interface UsuarioServiceInterface {
	
	MensagemResponseDTO inserir(Usuario user);
	MensagemResponseDTO alterar(Long id, Usuario user) throws UsuarioNotFoundExceptional;
	MensagemResponseDTO remover(Long id) throws UsuarioNotFoundExceptional;
	
	Usuario findById(Long id) throws UsuarioNotFoundExceptional;
	List<Usuario> findAll();
}
