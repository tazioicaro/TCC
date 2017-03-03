package com.bb.controller.services.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;

import com.bb.controller.control.repository.Departamentos;
import com.bb.models.Departamento;

@FacesConverter(value="converterPickList")
public class DepartamentoConverterPickList implements Converter {

	@Inject
	private Departamentos departamentos;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		 Object ret = null;
		    if (component instanceof PickList) {
		        Object dualList = ((PickList) component).getValue();
		        DualListModel dl = (DualListModel) dualList;
		        for (Object o : dl.getSource()) {
		            String id = "" + ((Departamento) o).getCodigo();
		            if (value.equals(id)) {
		                ret = o;
		                break;
		            }
		        }
		        if (ret == null)
		            for (Object o : dl.getTarget()) {
		                String id = "" + ((Departamento) o).getCodigo();
		                if (component.equals(id)) {
		                    ret = o;
		                    break;
		                }
		            }
		    }
		    return ret;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		 String str = "";
		    if (value instanceof Departamento) {
		        str = "" + ((Departamento) value).getCodigo();
		    }
		    return str;
	}

}
