package org.labs.candidaturas.domain.service.impl;

import java.util.List;

import org.labs.candidaturas.domain.entity.Candidato;
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
	public String inserir(Candidato candidato) {
		repository.save(candidato);
		return "Candidato de ID: "+candidato.getCandidatoId()+" adicionado com sucesso!"; 
	}

	@Override
	public String alterar(Long id, Candidato candidato) {
		candidato.setCandidatoId(id);
		repository.saveAndFlush(candidato);
		return "Candidato de ID: "+candidato.getCandidatoId()+" alterado com sucesso!";
	}

	@Override
	public String remover(Long id) {
		Candidato candidato = findById(id);
		repository.delete(candidato);
		return "Candidato de ID: "+candidato.getCandidatoId()+" removido com sucesso!";
	}

	@Override
	public Candidato findById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Candidato> findAll() {
		return repository.findAll();
	}

}
