package org.labs.candidaturas.domain.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.labs.candidaturas.domain.enums.Bandeira;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartaoDeCreditoDTO {
	
	private Long cartaoId;
	
	@NotEmpty
	private String numero;
	
	@NotNull
	private int codigo;
	
	@NotNull
	private String dataValidacao;
	
	@NotNull
	private Bandeira bandeira;
		
}
