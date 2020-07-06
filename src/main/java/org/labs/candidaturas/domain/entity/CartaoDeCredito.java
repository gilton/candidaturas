package org.labs.candidaturas.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
	
	@NotEmpty
	private String numero;
	
	@NotNull
	@Column(name = "codigo", insertable = true, length = 5)
	private int codigo;
	
	@NotNull
	private String dataValidacao;
	
	@Enumerated(EnumType.STRING)
	private Bandeira bandeira;
		
}
