package com.bb.controller.control.cadastros;

import java.io.Serializable;

import com.bb.models.Fornecedor;

public class CadastroFornecedorBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Fornecedor fornecedor;

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	
	

}
