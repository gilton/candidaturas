package org.labs.candidaturas.domain.service.impl;

import java.util.List;

import org.labs.candidaturas.domain.entity.Usuario;
import org.labs.candidaturas.domain.repository.UsuarioRepository;
import org.labs.candidaturas.domain.service.interfaces.UsuarioServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioService implements UsuarioServiceInterface {
	
	
	private UsuarioRepository repository;
	

	@Override
	public String inserir(Usuario user) {
		repository.save(user);
		return "Usuário de ID: "+user.getUsuarioId()+" adicionado com sucesso!"; 
	}

	@Override
	public String alterar(Long id, Usuario user) {
		user.setUsuarioId(id);
		repository.saveAndFlush(user);
		return "Usuário de ID: "+user.getUsuarioId()+" alterado com sucesso!";
	}

	@Override
	public String remover(Long id) {
		Usuario user = findById(id);
		repository.delete(user);
		return "Usuário de ID: "+user.getUsuarioId()+" removido com sucesso!";
	}

	@Override
	public Usuario findById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Usuario> findAll() {
		return repository.findAll();
	}

}
