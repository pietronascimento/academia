/**
 * @(#) UtilErrorMessage.java 1.0 27/01/2021
 *
 * Copyright 2014 Pietro do Nascimento, Todos os direitos reservados. 
 * PROPRIEDADE Pietro do Nascimento/CONFINDECIAL. Uso sujeito a condicoes de licenca.
 */
package br.com.bodysportacademia.util;

import com.vaadin.server.ErrorMessage;
import com.vaadin.shared.ui.ErrorLevel;

/**
 * @version 1.0 27/01/2021
 * @author Pietro do Nascimento
 */
public class UtilErrorMessage implements ErrorMessage {
	private static final long serialVersionUID = -2874521847692974937L;
	
	private String message = "";
    
    public UtilErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public ErrorLevel getErrorLevel() {
        return ErrorLevel.ERROR;
    }

    @Override
    public String getFormattedHtmlMessage() {
        return message;
    }
}
