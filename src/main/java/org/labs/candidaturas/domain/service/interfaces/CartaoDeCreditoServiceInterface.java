package org.labs.candidaturas.domain.service.interfaces;

import java.util.List;

import org.labs.candidaturas.domain.entity.CartaoDeCredito;

public interface CartaoDeCreditoServiceInterface {
	
	String inserir(CartaoDeCredito cartaoDeCredito);
	String alterar(Long id, CartaoDeCredito cartaoDeCredito);
	String remover(Long id);
	
	CartaoDeCredito findById(Long id);
	List<CartaoDeCredito> findAll();
}
