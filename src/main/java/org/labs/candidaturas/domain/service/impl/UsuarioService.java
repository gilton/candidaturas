package org.labs.candidaturas.domain.service.impl;

import java.util.List;

import org.labs.candidaturas.domain.dto.MensagemResponseDTO;
import org.labs.candidaturas.domain.entity.Usuario;
import org.labs.candidaturas.domain.exception.UsuarioNotFoundExceptional;
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
	public MensagemResponseDTO inserir(Usuario user) {
		repository.save(user);
		
		return MensagemResponseDTO.builder()
				.mensagem(String.format("Usuário de ID %s, adicionado com sucesso!", user.getUsuarioId()))
				.build();
	}

	@Override
	public MensagemResponseDTO alterar(Long id, Usuario user) throws UsuarioNotFoundExceptional {
		
		Usuario userEncontrado = repository.findById(id).orElseThrow(()-> new UsuarioNotFoundExceptional(id));
		user.setUsuarioId(userEncontrado.getUsuarioId());
		
		repository.saveAndFlush(user);
		
		return MensagemResponseDTO.builder()
				.mensagem(String.format("Usuário de ID %s, alterado com sucesso!", user.getUsuarioId()))
				.build();
	}

	@Override
	public MensagemResponseDTO remover(Long id) throws UsuarioNotFoundExceptional {
		Usuario user = repository.findById(id).orElseThrow(()-> new UsuarioNotFoundExceptional(id));
		repository.delete(user);
		
		return MensagemResponseDTO.builder()
				.mensagem(String.format("Usuário de ID %s, removido com sucesso!", user.getUsuarioId()))
				.build();
	}

	@Override
	public Usuario findById(Long id) throws UsuarioNotFoundExceptional {
		return repository.findById(id).orElseThrow(()-> new UsuarioNotFoundExceptional(id));
	}

	@Override
	public List<Usuario> findAll() {
		return repository.findAll();
	}

}
