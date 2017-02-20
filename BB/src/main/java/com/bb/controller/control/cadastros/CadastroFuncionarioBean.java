package com.bb.controller.control.cadastros;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bb.controller.control.repository.Departamentos;
import com.bb.controller.control.repository.Grupos;
import com.bb.controller.security.GeradorSenha;
import com.bb.controller.services.CadastroFuncionarioServices;
import com.bb.controller.services.NegocioException;
import com.bb.controller.util.jsf.FacesUtil;
import com.bb.models.Departamento;
import com.bb.models.Endereco;
import com.bb.models.Funcionario;
import com.bb.models.Grupo;

@Named
@ViewScoped
public class CadastroFuncionarioBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroFuncionarioServices cadastroFuncionacioServices;
	private Funcionario usuario; // SelecOne 2°

	@Inject
	private Departamentos repositorioDepartamos;
	private Departamento departamentoPai; // CategoriaPai
	private List<Departamento> deps; // Categoria Raizes
	private List<Departamento> gerentes = new ArrayList<>(); // subcategorias

		
	@Inject
	private Grupos repositorioGrupos;
	private List<Grupo> listaGrupos;
	
	private Endereco endereco;
	private GeradorSenha geradorSenha;

	public CadastroFuncionarioBean() {
		limpar();

	}

	public void inicializar() {
		if (FacesUtil.notIsPostBack()) {
			deps = repositorioDepartamos.porDepartamento();
			obterGrupos();

			if (this.departamentoPai != null) {
				obterGerente();
			}
		}
	}

	public void obterGerente() {
		gerentes = repositorioDepartamos.porGerente(departamentoPai);

	}

	public void cadastrar() {

		try {
			this.usuario.setSenha("123");
			this.usuario.setSenha(geradorSenha.geradorHash(this.usuario.getSenha()));
			
			this.usuario = cadastroFuncionacioServices.salvar(this.usuario);

			FacesUtil.addInforMessage("Funcionário " + usuario.getNome() + " cadastrado com sucesso!");
			limpar();

		} catch (NegocioException | NoSuchAlgorithmException | UnsupportedEncodingException ne) {

			FacesUtil.addErrorMessage(ne.getMessage());
		}
	}

	List<Grupo> obterGrupos() {
		return this.listaGrupos = repositorioGrupos.porGrupos();
	}

	public void limpar() {
		usuario = new Funcionario();
		departamentoPai = null;
		gerentes = new ArrayList<>();
		endereco = new Endereco();
		usuario.setEndereco(endereco);
		

		listaGrupos = new ArrayList<>();
		geradorSenha = new GeradorSenha();

	}

	// G&S
	public Funcionario getUsuario() {
		return usuario;
	}

	public void setUsuario(Funcionario usuario) {
		this.usuario = usuario;

		if (this.usuario != null) {
			this.departamentoPai = this.usuario.getDepartamento_codigo();
		}

	}

	public List<Grupo> getListaGrupos() {
		return listaGrupos;
	}

	public void setListaGrupos(List<Grupo> listaGrupos) {
		this.listaGrupos = listaGrupos;
	}

	public List<Departamento> getDeps() {
		return deps;
	}

	public void setDeps(List<Departamento> deps) {
		this.deps = deps;
	}

	public Departamento getDepartamentoPai() {
		return departamentoPai;
	}

	public void setDepartamentoPai(Departamento departamentoPai) {
		this.departamentoPai = departamentoPai;
	}

	public List<Departamento> getGerentes() {
		return gerentes;
	}

	public void setGerentes(List<Departamento> gerentes) {
		this.gerentes = gerentes;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}