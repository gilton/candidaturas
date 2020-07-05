package org.labs.candidaturas.domain.service.interfaces;

import java.util.List;

import org.labs.candidaturas.domain.dto.MensagemResponseDTO;
import org.labs.candidaturas.domain.entity.CartaoDeCredito;
import org.labs.candidaturas.domain.exception.CartaoDeCreditoNotFoundExceptional;

public interface CartaoDeCreditoServiceInterface {
	
	MensagemResponseDTO inserir(CartaoDeCredito cartaoDeCredito);
	MensagemResponseDTO alterar(Long id, CartaoDeCredito cartaoDeCredito) throws CartaoDeCreditoNotFoundExceptional;
	MensagemResponseDTO remover(Long id) throws CartaoDeCreditoNotFoundExceptional;
	
	CartaoDeCredito findById(Long id) throws CartaoDeCreditoNotFoundExceptional;
	List<CartaoDeCredito> findAll();
}
