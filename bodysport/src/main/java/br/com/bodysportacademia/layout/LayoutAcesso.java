package br.com.bodysportacademia.layout;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.data.Binder;
import com.vaadin.data.ValidationException;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import br.com.bodysportacademia.entity.EntityAcesso;

public class LayoutAcesso extends VerticalLayout {
	private static final long serialVersionUID = 926997966859169075L;
	
	public LayoutAcesso() {
		this(new EntityAcesso());
	}
	
	public LayoutAcesso(EntityAcesso e_acesso) {
		super.setSpacing(false);
		super.setSizeFull();
		
		b_validation = new BeanValidationBinder<>(EntityAcesso.class);
		b_validation.readBean(this.e_acesso = e_acesso);
		
		email = new TextField("E-Mail");
		b_validation.bind(email, "email");
		email.setRequiredIndicatorVisible(true);
		email.setWidthFull();
		super.addComponent(email);
		senha1 = new PasswordField("Senha");
		b_validation.bind(senha1, "senha");
		senha1.setRequiredIndicatorVisible(true);
		senha1.setWidthFull();
		super.addComponent(senha1);
		senha2 = new PasswordField("Repetir senha");
		b_validation.forField(senha2)
			.asRequired("O campo repetir senha deve ser preenchido!")
			.withValidator(s -> senha1.getValue().equals(s), "A Senha não confere!")
			.bind("senha");
		senha2.setRequiredIndicatorVisible(true);
		senha2.setWidthFull();
		super.addComponent(senha2);		
		ativo = new CheckBox("Ativo", true);
		b_validation.bind(ativo, "ativo");
		ativo.setWidthFull();
		super.addComponent(ativo);
	}
	
	public void setDataLayout(EntityAcesso e_acesso) {
		b_validation.readBean(this.e_acesso = e_acesso);
	}
	
	public EntityAcesso getDataLayout() {
		try {
			b_validation.writeBean(e_acesso);
			return e_acesso;
        } catch (ValidationException e) {
        	return null;
        }
	}
	
	private TextField email;
	private PasswordField senha1;
	private PasswordField senha2;
	private CheckBox ativo;
	private EntityAcesso e_acesso;
	private Binder<EntityAcesso> b_validation;
}
