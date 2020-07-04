package org.labs.candidaturas.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.labs.candidaturas.domain.enums.Nivel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "candidatoId")
public class Candidato {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long candidatoId;
	
	private String nome;
	private String cpf;
	private String skills;
	private Nivel nivel;
	
}
