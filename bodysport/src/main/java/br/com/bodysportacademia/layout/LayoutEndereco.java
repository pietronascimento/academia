package br.com.bodysportacademia.layout;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.data.Binder;
import com.vaadin.data.ValidationException;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import br.com.bodysportacademia.entity.EntityEndereco;
import br.com.bodysportacademia.util.UtilEstado;

public class LayoutEndereco extends VerticalLayout {
	private static final long serialVersionUID = 8356273808544484227L;

	public LayoutEndereco() {
		this(new EntityEndereco());
	}

	public LayoutEndereco(EntityEndereco e_endereco) {
		super.setSpacing(false);
		super.setSizeFull();

		b_validation = new BeanValidationBinder<>(EntityEndereco.class);
		b_validation.readBean(this.e_endereco = e_endereco);

		logradouro = new TextField("Logradouro");
		b_validation.bind(logradouro, "logradouro");
		logradouro.setRequiredIndicatorVisible(true);
		logradouro.setWidthFull();
		super.addComponent(logradouro);
		complemento = new TextField("Complemento");
		b_validation.bind(complemento, "complemento");
		complemento.setWidthFull();
		super.addComponent(complemento);
		bairro = new TextField("Bairro");
		b_validation.bind(bairro, "bairro");
		bairro.setRequiredIndicatorVisible(true);
		bairro.setWidthFull();
		super.addComponent(bairro);

		HorizontalLayout h_layout = new HorizontalLayout();
		h_layout.setSpacing(true);
		h_layout.setWidthFull();
		super.addComponent(h_layout);

		cidade = new TextField("Cidade");
		b_validation.bind(cidade, "cidade");
		cidade.setRequiredIndicatorVisible(true);
		cidade.setWidthFull();
		h_layout.addComponent(cidade);
		h_layout.setExpandRatio(cidade, 1F);
		estado = new ComboBox<>("UF");
		b_validation.bind(estado, "estado");
		estado.setRequiredIndicatorVisible(true);
		estado.setItems(UtilEstado.values());
		//estado.setItemLabelGenerator(UtilEstado::getEstado);
		estado.setWidth("70px");
		h_layout.addComponent(estado);

		cep = new TextField("Cep");
		b_validation.bind(cep, "cep");
		cep.setWidth("150px");
		super.addComponent(cep);
	}

	public void setDataLayout(EntityEndereco e_endereco) {
		b_validation.readBean(this.e_endereco = e_endereco);
	}

	public EntityEndereco getDataLayout() {
		try {
			b_validation.writeBean(e_endereco);
			return e_endereco;
		} catch (ValidationException e) {
			return null;
		}
	}

	private TextField logradouro;
	private TextField complemento;
	private TextField bairro;
	private TextField cidade;
	private ComboBox<UtilEstado> estado;
	private TextField cep;
	private EntityEndereco e_endereco;
	private Binder<EntityEndereco> b_validation;
}
