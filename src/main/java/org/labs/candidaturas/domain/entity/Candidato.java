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
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.labs.candidaturas.domain.enums.Nivel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	
	@NotEmpty
	@CPF
	@Column(nullable = false, unique = true)
	private String cpf;
	
	@NotEmpty
	@Size(min = 2, max = 250)
	private String nome;
	
	private String skills;
	
	@Enumerated(EnumType.STRING)
	private Nivel nivel;
	
	@Valid
	@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name="usuarioId")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Usuario usuario;
	
	@Valid
	@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name="cartaoId")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private CartaoDeCredito cartaoDeCredito;
	
}
