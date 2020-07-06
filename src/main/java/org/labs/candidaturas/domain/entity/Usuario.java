package org.labs.candidaturas.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
@EqualsAndHashCode(of = "usuarioId")
public class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long usuarioId;
	
	@NotEmpty
	private String login;
	
	@NotNull
	@Min(value = 4, message = "Senha precisa ter no mínimo 4 caracteres")
    @Max(value = 18, message = "Senha precisa ter no máximo 18 caracteres")
	private String senha;
	
	@NotNull
	@Size(max = 200)
	private String email;
	
	
}
