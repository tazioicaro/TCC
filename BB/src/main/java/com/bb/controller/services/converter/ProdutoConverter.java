package com.bb.controller.services.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.bb.controller.control.repository.Produtos;
import com.bb.controller.util.cdi.CDIServiceLocator;
import com.bb.models.Produto;

@FacesConverter(forClass = Produto.class)
public class ProdutoConverter implements Converter {

	//@Inject
	private Produtos produtos;

	public ProdutoConverter() {
		produtos = CDIServiceLocator.getBean(Produtos.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,	String value) {

		Produto retorno = null;

		if (value != null) {

			Long codigo = new Long(value);

			retorno = produtos.porCodigo(codigo);
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if( value !=null){
		    Produto produto = (Produto) value;				
			return produto.getCodigo() == null ? null :produto.getCodigo().toString();
		}
		return "";
	}

}
