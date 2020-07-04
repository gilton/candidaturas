package org.labs.candidaturas.domain.service.interfaces;

import java.util.List;

import org.labs.candidaturas.domain.entity.Usuario;

public interface UsuarioServiceInterface {
	
	String inserir(Usuario user);
	String alterar(Long id, Usuario user);
	String remover(Long id);
	
	Usuario findById(Long id);
	List<Usuario> findAll();
}
