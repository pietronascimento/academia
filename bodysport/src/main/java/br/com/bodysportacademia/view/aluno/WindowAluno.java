/**
 * @(#) WindowAluno.java 1.0 12/01/2021
 *
 * Copyright 2014 P Softwares, Todos os direitos reservados. PROPRIEDADE P
 * Softwares/CONFINDECIAL. Uso sujeito a condicoes de licenca.
 */
package br.com.bodysportacademia.view.aluno;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.data.Binder;
import com.vaadin.data.ValidationException;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import br.com.bodysportacademia.util.ui.UIPanel;
import br.com.bodysportacademia.util.ui.UIWindow;
import br.com.bodysportacademia.view.bean.BeanAluno;
import br.com.bodysportacademia.view.bean.ModelEstado;
import br.com.bodysportacademia.view.bean.ModelSexo;

/**
 * @version 1.0 12/01/2021
 * @author Pietro do Nascimento
 */
public class WindowAluno extends UIWindow {
	private static final long serialVersionUID = 8316791586894593510L;
	
	public WindowAluno() {
		super("Aluno");
		VerticalLayout v_layout = (VerticalLayout) super.getLayout();
		v_layout.setMargin(false);
		v_layout.setSpacing(true);
		
		v_layout.addComponent(createLayout1());
		v_layout.addComponent(createLayout2());
		v_layout.addComponent(createLayout3());
		v_layout.addComponent(createLayout4());
		
		binder = new BeanValidationBinder<>(BeanAluno.class);
		binder.bindInstanceFields(WindowAluno.this);
		
		HorizontalLayout h_layout = new HorizontalLayout();
		v_layout.setMargin(true);
		h_layout.setSpacing(true);
		v_layout.addComponent(h_layout);
		v_layout.setComponentAlignment(h_layout, Alignment.MIDDLE_RIGHT);
		
		cancelar = new Button("Cancelar");
		cancelar.setWidth("100px");
		h_layout.addComponent(cancelar);
		salvar = new Button("Salvar");
		salvar.addStyleName(ValoTheme.BUTTON_PRIMARY);
		salvar.setWidth("100px");
		h_layout.addComponent(salvar);
		
		new WindowAlunoHandle(WindowAluno.this);
		
		super.setModal(true);
		super.setWidth("500px");
		super.setHeight("400px");
	}
	
	public void setDataPanel(BeanAluno m_aluno) {
		binder.readBean(this.m_aluno = m_aluno);
	}
	
	public BeanAluno getDataPanel() {
		try {
			binder.writeBean(m_aluno);
			return m_aluno;
		} catch (ValidationException ex) {
			System.out.println("Test binder" + ex);
			return null;
		}
	}

	private UIPanel createLayout1() {
		UIPanel u_layout = new UIPanel("Dados Pessoais", new VerticalLayout());
		u_layout.setWidthFull();
		u_layout.setHeight("300px");
		
		VerticalLayout v_layout = (VerticalLayout) u_layout.getLayout();
		v_layout.setSpacing(true);
		v_layout.setSizeFull();

		cpf = new TextField("Cpf");
		cpf.setRequiredIndicatorVisible(true);
		cpf.setWidthFull();
		v_layout.addComponent(cpf);
		nome = new TextField("Nome");
		nome.setRequiredIndicatorVisible(true);
		nome.setWidthFull();
		v_layout.addComponent(nome);
		sexo = new ComboBox<>("Sexo");
		sexo.setRequiredIndicatorVisible(true);
		sexo.setItems(ModelSexo.values());
		sexo.setWidthFull();
		v_layout.addComponent(sexo);
		dataNascimento = new DateField("Data nascimento");
		dataNascimento.setRequiredIndicatorVisible(true);
		dataNascimento.setWidthFull();
		v_layout.addComponent(dataNascimento);
		filiacao = new TextField("Filiação");
		filiacao.setWidthFull();
		v_layout.addComponent(filiacao);

		return u_layout;
	}

	private UIPanel createLayout2() {
		UIPanel u_layout = new UIPanel("Acesso", new VerticalLayout());
		u_layout.setWidthFull();
		u_layout.setHeight("200px");

		VerticalLayout v_layout = (VerticalLayout) u_layout.getLayout();
		v_layout.setSpacing(true);
		v_layout.setSizeFull();
		
		email = new TextField("E-Mail");
		email.setRequiredIndicatorVisible(true);
		email.setWidthFull();
		v_layout.addComponent(email);
		senha1 = new PasswordField("Senha");
		senha1.setRequiredIndicatorVisible(true);
		senha1.setWidthFull();
		v_layout.addComponent(senha1);
		senha2 = new PasswordField("Repetir senha");
		senha2.setRequiredIndicatorVisible(true);
		senha2.setWidthFull();
		v_layout.addComponent(senha2);
		
		return u_layout;
	}

	private UIPanel createLayout3() {
		UIPanel u_layout = new UIPanel("Contato", new VerticalLayout());
		u_layout.setWidthFull();
		u_layout.setHeight("150px");
		
		VerticalLayout v_layout = (VerticalLayout) u_layout.getLayout();
		v_layout.setSpacing(true);
		v_layout.setSizeFull();
		
		telefone = new TextField("Telefone");
		telefone.setWidthFull();
		v_layout.addComponent(telefone);
		celular = new TextField("Celular");
		celular.setRequiredIndicatorVisible(true);
		celular.setWidthFull();
		v_layout.addComponent(celular);
		
		return u_layout;
	}

	private UIPanel createLayout4() {
		UIPanel u_layout = new UIPanel("Endereço", new VerticalLayout());
		u_layout.setWidthFull();
		u_layout.setHeight("300px");
		
		VerticalLayout v_layout = (VerticalLayout) u_layout.getLayout();
		v_layout.setSpacing(true);
		v_layout.setSizeFull();
		
		logradouro = new TextField("Logradouro");
		logradouro.setRequiredIndicatorVisible(true);
		logradouro.setWidthFull();
		v_layout.addComponent(logradouro);
		complemento = new TextField("Complemento");
		complemento.setWidthFull();
		v_layout.addComponent(complemento);
		bairro = new TextField("Bairro");
		bairro.setRequiredIndicatorVisible(true);
		bairro.setWidthFull();
		v_layout.addComponent(bairro);
		
		HorizontalLayout h_layout = new HorizontalLayout();
		h_layout.setSpacing(true);
		h_layout.setWidthFull();
		v_layout.addComponent(h_layout);
		
		cidade = new TextField("Celular");
		cidade.setRequiredIndicatorVisible(true);
		cidade.setWidthFull();
		h_layout.addComponent(cidade);
		h_layout.setExpandRatio(cidade, 1F);
		estado = new ComboBox<>("UF");
		estado.setItems(ModelEstado.values());
		estado.setRequiredIndicatorVisible(true);
		estado.setWidth("60px");
		h_layout.addComponent(estado);
		
		cep = new TextField("Cep");
		cep.setWidth("100px");
		v_layout.addComponent(cep);
		
		return u_layout;
	}

	private BeanAluno m_aluno;
	private Binder<BeanAluno> binder;
	
	private TextField cpf;
	private TextField nome;
	private ComboBox<ModelSexo> sexo;
	private DateField dataNascimento;
	private TextField filiacao;	
	private TextField email;
	private PasswordField senha1;
	private PasswordField senha2;	
	private TextField telefone;
	private TextField celular;	
	private TextField logradouro;
	private TextField complemento;
	private TextField bairro;
	private TextField cidade;
	private ComboBox<ModelEstado> estado;
	private TextField cep;
	
	protected Button salvar;
	protected Button cancelar;
}
