package org.labs.candidaturas.domain.service.interfaces;

import java.util.List;

import org.labs.candidaturas.domain.entity.Candidato;

public interface CandidatoServiceInterface {
	
	String inserir(Candidato candidato);
	String alterar(Long id, Candidato candidato);
	String remover(Long id);
	
	Candidato findById(Long id);
	List<Candidato> findAll();
}
