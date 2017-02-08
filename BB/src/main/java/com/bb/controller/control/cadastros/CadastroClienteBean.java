package com.bb.controller.control.cadastros;

import java.io.Serializable;

import javax.faces.component.html.HtmlSelectOneRadio;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bb.controller.services.CadastroClienteService;
import com.bb.controller.services.NegocioException;
import com.bb.controller.util.jsf.FacesUtil;
import com.bb.models.Cliente;
import com.bb.models.Enumerators.TipoPessoa;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cliente cliente;
	
//  private Endereco endereco;
//  private Servico servicos;
//	@NotNull
//	private Especialidade especialidadePai;
//	private List<Especialidade> especialidadesRaizes;
//	private List<Especialidade> servicoDeEspecialidades;
//	@Inject
//	private Especialidades especialidades;
//	private List<Endereco> enderecos;
	
	private HtmlSelectOneRadio radio;
	private boolean cpf;
	private boolean cnpj;


	
	@Inject
	private CadastroClienteService cadastroClienteService;

	public CadastroClienteBean() {
		limpar();
	}


	public void inicializar() {
		// if(FacesUtil.notIsPostBack()){
		// especialidadesRaizes = especialidades.raizes();
		// }

		if (this.cliente == null) {

			limpar();

		}
		
//		enderecos.add(endereco);
//		cliente.setEnderecos(enderecos);

	}	

	public void cadastrar() {
	
		try {			
			this.cliente = cadastroClienteService.salvar(this.cliente);
			FacesUtil.addInforMessage("Cliente Cadastrado com sucesso!");
			limpar();

		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());

		}

	}

	void limpar() {

		//enderecos = new ArrayList<Endereco>();
		cliente = new Cliente();
		//endereco = new Endereco();		
		cpf = false;
		cnpj = false;
		radio = null;

	}
	
		
	public void carregarInputDocumentoIdentificacao(){
		if(this.radio.getValue().toString().equals("FISICA")){
			cliente.setTipo(TipoPessoa.FISICA);
			this.cpf = true;
			this.cnpj=false;
		}
		
		if(this.radio.getValue().toString().equals("JURIDICA")){
			cliente.setTipo(TipoPessoa.JURIDICA);
			this.cnpj = true;
			this.cpf=false;
			
		}
	}
	
	public void pegarDadosEscolhido (ValueChangeEvent event){
		
		radio = (HtmlSelectOneRadio) event.getComponent();
	}
	
	public TipoPessoa[] getTipoPessoa() {
		return TipoPessoa.values();
	}
	

	// G&S

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

//	public Endereco getEndereco() {
//		return endereco;
//	}
//
//	public void setEndereco(Endereco endereco) {
//		this.endereco = endereco;
//	}

//	public List<Endereco> getEnderecos() {
//		return enderecos;
//	}
//
//	public void setEnderecos(List<Endereco> enderecos) {
//		this.enderecos = enderecos;
//	}


	public boolean isEditando(){
		
		if (this.cliente.getCodigo() != null){
			
			if(this.cliente.getDocumentoReceitaFederal().length()<=14 && isMaiorZero()){
				
				this.cpf = true;
				this.cnpj= false;
			}
			
			if (this.cliente.getDocumentoReceitaFederal().length() >14 && isMaiorZero()){
				this.cnpj = true;
				this.cpf = false;
			}
		}
		
		return true;
	}
	
	public boolean isMaiorZero(){
		
		return this.cliente.getDocumentoReceitaFederal().length() >= 0;
		
	}
	
	
	public HtmlSelectOneRadio getRadio() {
		return radio;
	}


	public void setRadio(HtmlSelectOneRadio radio) {
		this.radio = radio;
	}


	public boolean isCpf() {
		return cpf;
	}


	public void setCpf(boolean cpf) {
		this.cpf = cpf;
	}


	public boolean isCnpj() {
		return cnpj;
	}


	public void setCnpj(boolean cnpj) {
		this.cnpj = cnpj;
	}
	
	
	
	// public Servico getServicos() {
	// return servicos;
	// }

//	public List<Especialidade> getEspecialidadesRaizes() {
//		return especialidadesRaizes;
//	}
//
//	public List<Especialidade> getServicoDeEspecialidades() {
//		return servicoDeEspecialidades;
//	}
//
//	public Especialidades getEspecialidades() {
//		return especialidades;
//	}
//
//	public void setEspecialidades(Especialidades especialidades) {
//		this.especialidades = especialidades;
//	}
//
//	public Especialidade getEspecialidadePai() {
//		return especialidadePai;
//	}
//
//	public void setEspecialidadePai(Especialidade especialidadePai) {
//		this.especialidadePai = especialidadePai;
//	}

	// public void setServicos(Servico servicos) {
	// this.servicos = servicos;
	// }

}
