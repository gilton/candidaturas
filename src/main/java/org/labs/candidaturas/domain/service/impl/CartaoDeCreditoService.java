package org.labs.candidaturas.domain.service.impl;

import java.util.List;

import org.labs.candidaturas.domain.entity.CartaoDeCredito;
import org.labs.candidaturas.domain.repository.CartaoDeCreditoRepository;
import org.labs.candidaturas.domain.service.interfaces.CartaoDeCreditoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CartaoDeCreditoService implements CartaoDeCreditoServiceInterface {
	
	
	private CartaoDeCreditoRepository repository;
	

	@Override
	public String inserir(CartaoDeCredito cartao) {
		repository.save(cartao);
		return "Cartão de Crédito de ID: "+cartao.getCartaoId()+" adicionado com sucesso!"; 
	}

	@Override
	public String alterar(Long id, CartaoDeCredito cartao) {
		cartao.setCartaoId(id);
		repository.saveAndFlush(cartao);
		return "Cartão de Crédito de ID: "+cartao.getCartaoId()+" alterado com sucesso!";
	}

	@Override
	public String remover(Long id) {
		CartaoDeCredito cartao = findById(id);
		repository.delete(cartao);
		return "Cartão de Crédito de ID: "+cartao.getCartaoId()+" removido com sucesso!";
	}

	@Override
	public CartaoDeCredito findById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public List<CartaoDeCredito> findAll() {
		return repository.findAll();
	}

}
