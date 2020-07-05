package org.labs.candidaturas.domain.service.impl;

import java.util.List;

import org.labs.candidaturas.domain.dto.MensagemResponseDTO;
import org.labs.candidaturas.domain.entity.Candidato;
import org.labs.candidaturas.domain.exception.CandidatoNotFoundExceptional;
import org.labs.candidaturas.domain.repository.CandidatoRepository;
import org.labs.candidaturas.domain.service.interfaces.CandidatoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CandidatoService implements CandidatoServiceInterface {
	
	
	private CandidatoRepository repository;
	

	@Override
	public MensagemResponseDTO inserir(Candidato candidato) {
		repository.save(candidato);
		 
		return MensagemResponseDTO.builder()
				.mensagem(String.format("Candidato de ID %s, adicionado com sucesso!", candidato.getCandidatoId()))
				.build();
	}

	@Override
	public MensagemResponseDTO alterar(Long id, Candidato candidato) throws CandidatoNotFoundExceptional {
		
		Candidato candidatoRecuperado = repository.findById(id).orElseThrow(() -> new CandidatoNotFoundExceptional(id));
		candidato.setCandidatoId(candidatoRecuperado.getCandidatoId());
		
		repository.saveAndFlush(candidato);
		
		return MensagemResponseDTO.builder()
				.mensagem(String.format("Candidato de ID %s, alterado com sucesso!",candidato.getCandidatoId()))
				.build(); 
	}

	@Override
	public MensagemResponseDTO remover(Long id) throws CandidatoNotFoundExceptional {
		Candidato candidato = repository.findById(id)
				.orElseThrow(() -> new CandidatoNotFoundExceptional(id));
		
		repository.delete(candidato);

		return MensagemResponseDTO.builder()
				.mensagem(String.format("Candidato de ID %s, removido com sucesso!",candidato.getCandidatoId()))
				.build(); 
	}

	@Override
	public Candidato findById(Long id) throws CandidatoNotFoundExceptional {
		return repository.findById(id).orElseThrow(() -> new CandidatoNotFoundExceptional(id));
	}

	@Override
	public List<Candidato> findAll() {
		return repository.findAll();
	}

}
