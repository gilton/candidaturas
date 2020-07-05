package org.labs.candidaturas.domain.service.interfaces;

import java.util.List;

import org.labs.candidaturas.domain.dto.MensagemResponseDTO;
import org.labs.candidaturas.domain.entity.Candidato;
import org.labs.candidaturas.domain.exception.CandidatoNotFoundExceptional;

public interface CandidatoServiceInterface {
	
	MensagemResponseDTO inserir(Candidato candidato);
	MensagemResponseDTO alterar(Long id, Candidato candidato) throws CandidatoNotFoundExceptional;
	MensagemResponseDTO remover(Long id) throws CandidatoNotFoundExceptional;
	
	Candidato findById(Long id) throws CandidatoNotFoundExceptional;
	List<Candidato> findAll();
}
