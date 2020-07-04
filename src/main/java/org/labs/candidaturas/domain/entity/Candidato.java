package org.labs.candidaturas.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
	
	@Column(nullable = false, unique = true)
	private String cpf;
	
	private String nome;
	private String skills;
	
	private Nivel nivel;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private Usuario usuario;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private CartaoDeCredito cartaoDeCredito;
	
}
