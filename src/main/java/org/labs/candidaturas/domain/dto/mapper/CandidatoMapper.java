package org.labs.candidaturas.domain.dto.mapper;

import org.labs.candidaturas.domain.dto.request.CandidatoDTO;
import org.labs.candidaturas.domain.entity.Candidato;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CandidatoMapper {
	
	
	CandidatoMapper INSTANCE = Mappers.getMapper(CandidatoMapper.class);

	@Mappings({
        @Mapping(source = "usuario", target = "usuario"),
        @Mapping(source = "cartaoDeCredito", target = "cartaoDeCredito"),
        @Mapping(source = "cpf", target = "cpf"),
        @Mapping(source = "nome", target = "nome"),
        @Mapping(source = "nivel", target = "nivel")
	})
	
	Candidato toModel(CandidatoDTO dto);
	
	CandidatoDTO toDTO(Candidato entity);
	
}
