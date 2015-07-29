package com.bb.controller.services;

/**
 * Customização de exceção.
 * 
 * Esta exceção é um exemplo, com conjunto com a tela de cadastro de Pedidos de como mostrar a mensagem da 
 * exceção e não encaminhá-la para outra página, como está acontecendo com outras exceções
 * @author tazio.fernandes
 *
 */
public class NegocioException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public NegocioException(String msg){
		super(msg);
	}
	
	

}
