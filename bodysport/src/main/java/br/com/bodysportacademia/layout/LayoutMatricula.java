package br.com.bodysportacademia.layout;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.data.Binder;
import com.vaadin.data.ValidationException;
import com.vaadin.data.converter.StringToDoubleConverter;
import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import br.com.bodysportacademia.dao.DAOAluno;
import br.com.bodysportacademia.dao.DAOMatriculaPlano;
import br.com.bodysportacademia.entity.EntityAluno;
import br.com.bodysportacademia.entity.EntityMatricula;
import br.com.bodysportacademia.entity.EntityMatriculaPlano;
import br.com.bodysportacademia.util.ui.mask.MaskNumberField;

public class LayoutMatricula extends VerticalLayout {
	private static final long serialVersionUID = -8529910627177258150L;
	
	public LayoutMatricula() {
		super.setSpacing(false);
		super.setSizeFull();
		
		aluno = new ComboBox<>("Aluno");
		aluno.setRequiredIndicatorVisible(true);		
		aluno.setItemCaptionGenerator(EntityAluno::getNome);
		aluno.setItems(new DAOAluno().listarTodos());
		aluno.setWidthFull();
		super.addComponent(aluno);
		
		HorizontalLayout h_layout = new HorizontalLayout();
		h_layout.setSpacing(true);
		h_layout.setWidthFull();
		super.addComponent(h_layout);
		
		data = new DateField("Data");
		data.setRequiredIndicatorVisible(true);
		data.setWidthFull();
		h_layout.addComponent(data);		
		diaVencimento = new TextField("Dia vencimento");
		diaVencimento.setRequiredIndicatorVisible(true);
		diaVencimento.setWidthFull();
		h_layout.addComponent(diaVencimento);
		
		h_layout = new HorizontalLayout();
		h_layout.setSpacing(true);
		h_layout.setWidthFull();
		super.addComponent(h_layout);
		
		valor = new TextField("Valor matrícula");
		valor.setRequiredIndicatorVisible(true);
		valor.setWidthFull();
		h_layout.addComponent(valor);		
		desconto = new MaskNumberField("Desconto");
		//desconto.setRequiredIndicatorVisible(true);
		desconto.setWidthFull();
		h_layout.addComponent(desconto);
		
		plano = new ComboBox<>("Plano");
		plano.setRequiredIndicatorVisible(true);
		plano.setItemCaptionGenerator(EntityMatriculaPlano::getNome);
		plano.setItems(new DAOMatriculaPlano().listarTodos());
		plano.setWidthFull();
		super.addComponent(plano);
		
		ativo = new CheckBox("Ativo");
		ativo.setWidthFull();
		super.addComponent(ativo);
		
		b_validation = new BeanValidationBinder<>(EntityMatricula.class);
		b_validation.bind(aluno, "aluno");
		b_validation.bind(data, "data");
		b_validation.forField(diaVencimento)
			.withConverter(new StringToIntegerConverter("Valor inválido!"))
			.bind("diaVencimento");
		b_validation.forField(valor)
			.withConverter(new StringToDoubleConverter("Valor inválido!"))
			.bind("valor");
		b_validation.forField(desconto)
			.withConverter(new StringToIntegerConverter("Valor inválido!"))
			.bind("desconto");
		b_validation.bind(plano, "plano");
		b_validation.bind(ativo, "ativo");
	}
	
	public void setDataPanel(EntityMatricula e_matricula) {
		//b_validation.readBean(e_matricula);
		b_validation.setBean(e_matricula);
	}
	
	public EntityMatricula getDataPanel() {
		try {
			EntityMatricula e_matricula = b_validation.getBean();
			b_validation.writeBean(e_matricula);
			return e_matricula;
        } catch (ValidationException e) {
        	return null;
        }
	}
	
	private ComboBox<EntityAluno> aluno;
	private DateField data;
	private TextField diaVencimento;
	private TextField valor;
	private TextField desconto;
	private ComboBox<EntityMatriculaPlano> plano;	
	private CheckBox ativo;	
	private Binder<EntityMatricula> b_validation;
}
