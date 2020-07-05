package org.labs.candidaturas.domain.service.impl;

import java.util.List;

import org.labs.candidaturas.domain.dto.MensagemResponseDTO;
import org.labs.candidaturas.domain.entity.CartaoDeCredito;
import org.labs.candidaturas.domain.exception.CartaoDeCreditoNotFoundExceptional;
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
	public MensagemResponseDTO inserir(CartaoDeCredito cartao) {
		repository.save(cartao);
		
		return MensagemResponseDTO.builder()
				.mensagem(String.format("Cartão de Crédito de ID %s, adicionado com sucesso!",cartao.getCartaoId()))
				.build();
	}

	@Override
	public MensagemResponseDTO alterar(Long id, CartaoDeCredito cartao) throws CartaoDeCreditoNotFoundExceptional {
		
		CartaoDeCredito cartaoEncontrado = repository.findById(id)
													.orElseThrow(() -> new CartaoDeCreditoNotFoundExceptional(id));
		cartao.setCartaoId(cartaoEncontrado.getCartaoId());
		
		repository.saveAndFlush(cartao);
		
		return MensagemResponseDTO.builder()
				.mensagem(String.format("Cartão de Crédito de ID %s, alterado com sucesso!",cartao.getCartaoId()))
				.build(); 
	}

	@Override
	public MensagemResponseDTO remover(Long id) throws CartaoDeCreditoNotFoundExceptional {
		CartaoDeCredito cartao = repository.findById(id)
											.orElseThrow(() -> new CartaoDeCreditoNotFoundExceptional(id));
		repository.delete(cartao);
		
		return MensagemResponseDTO.builder()
				.mensagem(String.format("Cartão de Crédito de ID %s, removido com sucesso!",cartao.getCartaoId()))
				.build(); 
	}

	@Override
	public CartaoDeCredito findById(Long id) throws CartaoDeCreditoNotFoundExceptional {
		return repository.findById(id).orElseThrow(() -> new CartaoDeCreditoNotFoundExceptional(id));
	}

	@Override
	public List<CartaoDeCredito> findAll() {
		return repository.findAll();
	}

}
