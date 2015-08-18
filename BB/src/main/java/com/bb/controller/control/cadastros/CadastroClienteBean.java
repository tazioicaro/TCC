package com.bb.controller.control.cadastros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import com.bb.controller.util.jsf.FacesUtil;
import com.bb.controller.control.repository.Especialidades;
import com.bb.models.Cliente;
import com.bb.models.Endereco;
import com.bb.models.Especialidade;
import com.bb.models.Servicos;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private  Cliente cliente;
	private Endereco endereco;
	private Servicos servicos;
	
	@NotNull
	private Especialidade especialidadePai;
	
	private List<Especialidade> especialidadesRaizes;	
	private List<Especialidade> servicoDeEspecialidades;
	private List<Endereco> enderecos;
	

	@Inject
	private Especialidades especialidades;
	
	
	
	
	
	public CadastroClienteBean() {
		enderecos = new ArrayList<Endereco>();
		cliente = new Cliente();
		endereco = new Endereco();
		servicos = new Servicos();
		
		
		enderecos.add(endereco);		
		cliente.setEnderecos(enderecos);
	}
	
	
	public void inicializar(){
		if(FacesUtil.notIsPostBack()){
		especialidadesRaizes = especialidades.raizes();
		}
	}
	
	public void carregarServicoDeEspecialidades(){
		
		servicoDeEspecialidades = especialidades.servicoDe(especialidadePai);
		
	}
	
	
public void salvar(){
		
		System.out.println("ESPECIALIDADE Selecionada: " +especialidadePai.getDescricao());
		
		System.out.println("Serviço Selecionado: " +servicos.getEspecialidade().getDescricao());
		
		
		
	}
	
	
	
	
	
	
	
	//G&S
	
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	public Servicos getServicos() {
		return servicos;
	}


	public List<Especialidade> getEspecialidadesRaizes() {
		return especialidadesRaizes;
	}


	public List<Especialidade> getServicoDeEspecialidades() {
		return servicoDeEspecialidades;
	}


	public Especialidades getEspecialidades() {
		return especialidades;
	}


	public void setEspecialidades(Especialidades especialidades) {
		this.especialidades = especialidades;
	}


	public Especialidade getEspecialidadePai() {
		return especialidadePai;
	}


	public void setEspecialidadePai(Especialidade especialidadePai) {
		this.especialidadePai = especialidadePai;
	}


	public void setServicos(Servicos servicos) {
		this.servicos = servicos;
	}




	
	
	}
