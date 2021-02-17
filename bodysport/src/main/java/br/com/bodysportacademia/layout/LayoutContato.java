package br.com.bodysportacademia.layout;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.data.Binder;
import com.vaadin.data.ValidationException;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import br.com.bodysportacademia.entity.EntityContato;
import br.com.bodysportacademia.util.ui.mask.MaskNumberCelular;
import br.com.bodysportacademia.util.ui.mask.MaskNumberFone;

public class LayoutContato extends VerticalLayout {
	private static final long serialVersionUID = -8400987866643702378L;
	
	public LayoutContato() {
		this(new EntityContato());
	}
	
	public LayoutContato(EntityContato e_contato) {
		super.setSpacing(false);
		super.setSizeFull();
		
		b_validation = new BeanValidationBinder<>(EntityContato.class);
		b_validation.readBean(this.e_contato = e_contato);
		
		telefone = new MaskNumberFone("Telefone");
		b_validation.bind(telefone, "telefone");
		telefone.setWidthFull();
		super.addComponent(telefone);
		celular = new MaskNumberCelular("Celular");
		b_validation.bind(celular, "celular");
		celular.setRequiredIndicatorVisible(true);
		celular.setWidthFull();
		super.addComponent(celular);
	}

	public void setDataLayout(EntityContato e_contato) {
		b_validation.readBean(this.e_contato = e_contato);
	}
	
	public EntityContato getDataLayout() {
		try {
			b_validation.writeBean(e_contato);
			return e_contato;
        } catch (ValidationException e) {
        	return null;
        }
	}
	
	private TextField telefone;
	private TextField celular;	
	private EntityContato e_contato;
	private Binder<EntityContato> b_validation;
}
