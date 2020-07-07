package org.labs.candidaturas.domain.dto.mapper;

import org.labs.candidaturas.domain.dto.request.UsuarioDTO;
import org.labs.candidaturas.domain.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
	
	UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

	Usuario toModel(UsuarioDTO dto);
	
	UsuarioDTO toDTO(Usuario entity);
	
}
