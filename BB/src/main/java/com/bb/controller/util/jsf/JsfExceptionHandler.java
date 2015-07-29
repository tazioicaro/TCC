package com.bb.controller.util.jsf;

import java.io.IOException;
import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bb.controller.services.NegocioException;



//Trata exceções

/**
 * Dentro da pagina CadastroProduto , no command button foi feito os seguintes
 * testes:
 * 
 * Inserido a tag ajax="false", iniciado a página com o tomcat e depois
 * reiniciado o tomcat. O comum é apresentar o erro.
 * 
 * Teste 2: alterado a tag ajax para true. O e refeito o teste. o Comum é não
 * paresentar erros na tela, mas sim nas requisições.
 * 
 * Como resolução utiliza-se o esta classe e a classe factory.
 * 
 * Obs.: Feito a configuração no faces-config
 * 
 * @author tazio.fernandes
 *
 */
public class JsfExceptionHandler extends ExceptionHandlerWrapper {
	
	
	private static Log log = LogFactory.getLog(JsfExceptionHandler.class);

	private ExceptionHandler wrapped;

	public JsfExceptionHandler(ExceptionHandler wrapped) {
		super();
		this.wrapped = wrapped;
	}

	@Override
	public ExceptionHandler getWrapped() {
		// TODO Auto-generated method stub
		return this.wrapped;
	}

	// Metodo responsavel por tratar as exceções capuradas pelo JSF
	@Override
	public void handle() throws FacesException {
		// Todos os evento de exceções enfileirados
		Iterator<ExceptionQueuedEvent> events = getUnhandledExceptionQueuedEvents()
				.iterator();

		while (events.hasNext()) {
			ExceptionQueuedEvent event = events.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event
					.getSource();

			// pego a excessão
			Throwable exception = context.getException();

			// Exceção customizada
			NegocioException negocioException = getNegocioException(exception);

			boolean handled = false;

			try {
				if (exception instanceof ViewExpiredException) {

					handled = true;
					redirect("/");
				} else if (negocioException != null) {
					handled=true;
					
					//Adicionando a mensagem no repositório de mensagens de erro do faces
					FacesUtil.addErrorMessage(negocioException.getMessage());

				} else {
					handled = true;
					
					//mensagem, e causa da exceção
					log.error("Erro de sistema: " + exception.getMessage(), exception);
					redirect("/Erro.xhtml");
				}
			} finally {
				// removendo a axceção do Iterate
				if (handled) {
					events.remove();
				}
			}
		}

		// Repassando para o Faces continuar tratando as exceções que não foram
		// pegos
		getWrapped().handle();
	}

	/**
	 * As vezes a exceção pode está encapsulada dentro de outra excessão como
	 * FacesException e etc;. Então é necessário verificar se existe uma
	 * excessão NegocioException
	 * 
	 * @param exception
	 * @return
	 */
	private NegocioException getNegocioException(Throwable exception) {

		//Se a exceção for um instancia de NegocioException
		if (exception instanceof NegocioException) {
			
			//Retorne a propria
			return (NegocioException) exception;
			
			//Caso o contrário, se a causa da excessão não for nula
		} else if (exception.getCause() != null) {
			
			//Chama a axcessão e busca por nível até zerar. Chama-se recursividade
			return getNegocioException(exception.getCause());
		}
		return null;

	}

	private void redirect(String page) {
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();

			ExternalContext externalContext = facesContext.getExternalContext();
			String contextPath = externalContext.getRequestContextPath(); // No
																			// caso
																			// é
																			// o
																			// PedidoVenda

			externalContext.redirect(contextPath + page);
			facesContext.responseComplete();
		} catch (IOException e) {
			throw new FacesException(e);
		}
	}

}
