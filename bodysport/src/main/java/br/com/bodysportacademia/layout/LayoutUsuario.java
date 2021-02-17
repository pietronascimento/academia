package br.com.bodysportacademia.layout;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.data.Binder;
import com.vaadin.data.ValidationException;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import br.com.bodysportacademia.entity.EntityUsuario;
import br.com.bodysportacademia.util.UtilSexo;
import br.com.bodysportacademia.util.ui.mask.MaskNumberCPF;

public class LayoutUsuario extends VerticalLayout {
	private static final long serialVersionUID = -4458501179586408709L;
	
	public LayoutUsuario() {
		this(new EntityUsuario());
	}
	
	public LayoutUsuario(EntityUsuario e_usuario) {
		super.setSpacing(false);
		super.setSizeFull();
		
		b_validation = new BeanValidationBinder<>(EntityUsuario.class);
		b_validation.readBean(this.e_usuario = e_usuario);
		
		cpf = new MaskNumberCPF("Cpf");
		b_validation.bind(cpf, "cpf");
		cpf.setRequiredIndicatorVisible(true);
		cpf.setWidthFull();
		super.addComponent(cpf);		
		nome = new TextField("Nome");
		b_validation.bind(nome, "nome");
		nome.setRequiredIndicatorVisible(true);
		nome.setWidthFull();		
		super.addComponent(nome);		
		sexo = new ComboBox<>("Sexo");
		b_validation.bind(sexo, "sexo");
		sexo.setRequiredIndicatorVisible(true);
		sexo.setItems(UtilSexo.values());
		//sexo.setItemCaptionGenerator(UtilSexo::getValue);
		sexo.setWidthFull();
		super.addComponent(sexo);		
		dataNascimento = new DateField("Data nascimento");
		b_validation.bind(dataNascimento, "dataNascimento");
		dataNascimento.setRequiredIndicatorVisible(true);
		dataNascimento.setWidthFull();		
		super.addComponent(dataNascimento);		
		filiacao = new TextField("Filiação");
		b_validation.bind(filiacao, "filiacao");
		filiacao.setWidthFull();
		super.addComponent(filiacao);
	}
	
	public void setDataLayout(EntityUsuario e_usuario) {
		b_validation.readBean(this.e_usuario = e_usuario);
	}
	
	public EntityUsuario getDataLayout() {
		try {
			b_validation.writeBean(e_usuario);
			return e_usuario;
        } catch (ValidationException e) {
        	return null;
        }
	}
	
	private TextField cpf;
	private TextField nome;
	private ComboBox<UtilSexo> sexo;
	private DateField dataNascimento;
	private TextField filiacao;	
	private EntityUsuario e_usuario;
	private Binder<EntityUsuario> b_validation;
}
