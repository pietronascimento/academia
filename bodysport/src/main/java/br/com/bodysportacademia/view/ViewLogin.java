/**
 * @(#) ViewLogin.java 1.0 16/02/2021
 *
 * Copyright 2014 Pietro do Nascimento, Todos os direitos reservados. 
 * PROPRIEDADE Pietro do Nascimento/CONFINDECIAL. 
 * Uso sujeito a condicoes de licenca.
 * 
 */
package br.com.bodysportacademia.view;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Notification.Type;

import br.com.bodysportacademia.Main;
import br.com.bodysportacademia.dao.DAOAcesso;
import br.com.bodysportacademia.entity.EntityAcesso;
import br.com.bodysportacademia.util.ui.UIPasswordField;
import br.com.bodysportacademia.util.ui.UITextField;

/**
 * @version 1.0 16/02/2021
 * @author Pietro do Nascimento
 */
public class ViewLogin extends VerticalLayout {
	private static final long serialVersionUID = -8406561046097529840L;
	
	public ViewLogin(Main main) {
		this.main = main;
		
		super.addStyleName("ps-login-layout");
		super.setSizeFull();
		
		VerticalLayout v_layout = createLayout();
		v_layout.setWidth("300px");
		super.addComponent(v_layout);
		super.setComponentAlignment(v_layout, Alignment.MIDDLE_CENTER);
	}
	
	private VerticalLayout createLayout() {
		VerticalLayout v_layout = new VerticalLayout();
		v_layout.addStyleName("ps-login-layout");
		v_layout.setMargin(true);
		v_layout.setSpacing(true);
		
		Image image = new Image(null, new ThemeResource("image/login_logo.png"));
		v_layout.addComponent(image);
		v_layout.setExpandRatio(image, 1F);
		v_layout.setComponentAlignment(image, Alignment.MIDDLE_CENTER);
		
		Label space = new Label(" ");
		space.setHeight("30px");
		v_layout.addComponent(space);
				
		username = new UITextField("Usuário");
		username.addStyleName("ps-login-textfield");
		username.setWidthFull();
		v_layout.addComponent(username);		
		password = new UIPasswordField("Senha");
		password.addStyleName("ps-login-textfield");
		password.setWidthFull();
		v_layout.addComponent(password);
		
		space = new Label(" ");
		space.setHeight("30px");
		v_layout.addComponent(space);
		
		login = new Button("login", e -> login());
		login.setPrimaryStyleName("ps-login-button");
		login.setWidthFull();
		v_layout.addComponent(login);
		reset = new Button("Esqueceu  sua senha?", e -> reset());
		reset.setPrimaryStyleName("ps-login-button-link");
		reset.setWidthFull();
		v_layout.addComponent(reset);
		
		return v_layout;
	}
	
	private void login() {
		if (isValidFields()) {
			EntityAcesso e_acesso 
				= new DAOAcesso().doLogin(
						username.getValue(), 
						password.getValue());
			if (e_acesso != null && e_acesso.getAtivo()) {
				main.setData(e_acesso);
				main.viewInit();
				removeStyle();
			} else {
				Notification.show(
						"!!! --- ERRO --- !!!", 
						"Usuário o senha inválidos!\n"
					  + "Entre em contato com o suporte.", 
						Type.ERROR_MESSAGE);
			}
		}
	}
	
	private void reset() {		
	}
	
	private boolean isValidFields() {
		if (username.isEmpty()) {
			username.focus();
			return false; 
		}
		if (password.isEmpty()) {
			password.focus();
			return false; 
		}
		return true;
	}
	
	private void removeStyle() {
		super.removeStyleName("ps-login-layout");
		username.removeStyleName("ps-login-textfield");
		password.removeStyleName("ps-login-textfield");
	}
	
	private Main main;
	private UITextField username;
	private UIPasswordField password;
	private Button login;
	private Button reset;
}
