package com.bb.controller.control.cadastros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import com.bb.controller.control.repository.Especialidades;
import com.bb.controller.control.repository.FornecedorRepository;
import com.bb.controller.control.repository.UnidadesMedidas;
import com.bb.controller.services.CadastroProdutoService;
import com.bb.controller.util.jsf.FacesUtil;
import com.bb.models.Especialidade;
import com.bb.models.Fornecedor;
import com.bb.models.Produto;
import com.bb.models.Servico;
import com.bb.models.ServicosProdutos;
import com.bb.models.ServicosProdutosId_OLD;
import com.bb.models.TipoProduto;
import com.bb.models.Unidade;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Inject
	private CadastroProdutoService produtoService;
	@Inject
	private UnidadesMedidas unidades;
	@Inject
	private FornecedorRepository fornecedorRp;
	@Inject
	private Especialidades categorias;
	
	
	private Produto produto;
	
	
	private List<Unidade> listaUnidade;
	
	
	private Fornecedor fornecedor;
	private List<Fornecedor> fornecedores;
	
	
	
	private TipoProduto tipoProduto;
	
	private List<Servico> servicos;
	private ServicosProdutosId_OLD spId;
	private ServicosProdutos sp;

	@NotNull
	private Especialidade categoriaPai;
	private List<Especialidade> categoriaRaizes;
	private List<Especialidade> subCategorias;
	
	

	

	

	public CadastroProdutoBean() {

		limpar();

	}

	public void inicializar() {
		
		
		if (FacesUtil.notIsPostBack()) {
			categoriaRaizes = categorias.raizes();
			listaUnidade = unidades.todas();
			fornecedores = fornecedorRp.todos();
			
			if (categoriaPai !=null){
				
				carregarCategoriasDe();
			}
						
		}
	}
	
	

	public void carregarCategoriasDe() {

		subCategorias = categorias.servicoDe(categoriaPai);

	}
	
	
	public void carregarDadosFornecedor(){
		
		fornecedor = fornecedorRp.porCodigo(this.produto.getFornecedor().getCodigo());
		
	}

	public void limpar() {

		servicos = new ArrayList<Servico>();		
		fornecedores = new ArrayList<Fornecedor>();;
		produto = new Produto();
		tipoProduto = new TipoProduto();
		sp = new ServicosProdutos();
		spId = new ServicosProdutosId_OLD();
		subCategorias = new ArrayList<Especialidade>();
		categoriaPai = null;
		listaUnidade = new ArrayList<Unidade>();

	}

	public void cadastrar() {
		
		this.produto.setDataInclusao(new Date());
		this.produto = produtoService.salvar(this.produto);
		FacesUtil.addInforMessage("Produto Salvo com sucesso");

		limpar();
	}
	
	public boolean isEditando(){
		return this.produto.getCodigo() !=null;
	}

	// G&S
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
		
		if(this.produto != null){
			this.categoriaPai = this.produto.getEspecialidade().getEspecialidadePai();
			this.fornecedor = this.produto.getFornecedor();	
			//listaUnidade = unidades.todas();			
			//fornecedores = fornecedorRp.todos();
			
		}
	}

	public List<Unidade> getListaUnidade() {
		return listaUnidade;
	}
	
	


	public void setListaUnidade(List<Unidade> listaUnidade) {
		this.listaUnidade = listaUnidade;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public Especialidade getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Especialidade categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

	public List<Especialidade> getCategoriaRaizes() {
		return categoriaRaizes;
	}

	public List<Especialidade> getSubCategorias() {
		return subCategorias;
	}

	public Especialidades getCategorias() {
		return categorias;
	}

	public void setCategorias(Especialidades categorias) {
		this.categorias = categorias;
	}

	public ServicosProdutosId_OLD getSpId() {
		return spId;
	}

	public void setSpId(ServicosProdutosId_OLD spId) {
		this.spId = spId;
	}

	public ServicosProdutos getSp() {
		return sp;
	}

	public void setSp(ServicosProdutos sp) {
		this.sp = sp;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;	
		
	}

}
