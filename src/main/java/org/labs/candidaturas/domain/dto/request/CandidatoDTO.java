package org.labs.candidaturas.domain.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.labs.candidaturas.domain.enums.Nivel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidatoDTO {
	
	@NotEmpty
	@CPF
	private String cpf;
	
	@NotEmpty
	@Size(min = 2, max = 250)
	private String nome;
	
	@Size(max = 250)
	private String skills;
	
	private Nivel nivel;
	
	private UsuarioDTO usuario;
	
	private CartaoDeCreditoDTO cartaoDeCredito;
	
}
