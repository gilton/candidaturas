package org.labs.candidaturas.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.labs.candidaturas.domain.enums.Nivel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@Builder
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
	
	@Enumerated(EnumType.STRING)
	private Nivel nivel;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name="usuarioId")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Usuario usuario;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name="cartaoId")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private CartaoDeCredito cartaoDeCredito;
	
	public Candidato() {super();}
	
}
