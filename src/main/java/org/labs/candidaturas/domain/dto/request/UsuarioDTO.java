package org.labs.candidaturas.domain.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
	
	private Long usuarioId;
	
	@NotEmpty
	private String login;
	
	@NotNull
	@Size(min = 4, max = 18, message = "A senha pode ter no mínimo 4 e no máximo 18 caracteres.")
	private String senha;
	
	@NotNull
	@Email
	@Size(max = 200)
	private String email;
	
	
}
