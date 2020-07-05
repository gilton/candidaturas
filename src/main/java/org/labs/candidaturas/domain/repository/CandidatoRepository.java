package org.labs.candidaturas.domain.repository;

import org.labs.candidaturas.domain.entity.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

}
