package ext.demo.jee6.jpa;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

import ext.demo.jee6.api.Address;
import ext.demo.jee6.api.AddressService;
import ext.demo.jee6.jpa.model.AddressEntity;

@ManagedBean
public class AddressConvertor implements Converter {

	        @Inject
	        private AddressService addresses;
	       
	        @Override
	        public Object getAsObject(FacesContext context, UIComponent component, String value) {
	                if (value == null) {
	                        return null;
	                }
	                int id = Integer.parseInt(value);
	               
	                return addresses.getById(id);
	        }

	        @Override
	        public String getAsString(FacesContext context, UIComponent component, Object value) {
	                if (value == null) {
	                        return null;
	                }
	                Long id = ((Address) value).getId();
	               
	                return (id != null) ? id.toString() : null;
	        }

	}



