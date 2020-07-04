package org.labs.candidaturas.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.labs.candidaturas.domain.enums.Bandeira;

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
@EqualsAndHashCode(of = "cartaoId")
public class CartaoDeCredito {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartaoId;
	
	private long numero;
	private int codSeguraca;
	private Bandeira bandeira;
	private Candidato candidado;
	
}
