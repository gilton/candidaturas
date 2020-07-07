package org.labs.candidaturas.domain.dto.mapper;

import org.labs.candidaturas.domain.dto.request.CartaoDeCreditoDTO;
import org.labs.candidaturas.domain.entity.CartaoDeCredito;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CartaoDeCreditoMapper {

	CartaoDeCreditoMapper INSTANCE = Mappers.getMapper(CartaoDeCreditoMapper.class);

	CartaoDeCredito toModel(CartaoDeCreditoDTO dto);
	
	CartaoDeCreditoDTO toDTO(CartaoDeCredito entity);
	
}
