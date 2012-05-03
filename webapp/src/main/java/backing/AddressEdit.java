package backing;

import static util.Messages.addFlashMessage;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ext.demo.jee6.api.Address;
import ext.demo.jee6.api.AddressService;
import ext.demo.jee6.jpa.model.AddressEntity;

@ManagedBean(name="addressEdit")
public class AddressEdit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7317803570273406205L;

	private static final Logger LOG = Logger.getLogger(AddressEdit.class.getName());
	  
	private Address address = new AddressEntity();
    
    @Inject
    private AddressService addressBean;
    
    public void preRenderView() {
    	LOG.info("preRenderView: ");
        if (address == null) {
        	address = new AddressEntity();
        }
    }
    
    public List<Address> getAllAddresses() {
    	
    	return addressBean.findAllAddresses();
    }
    
    public Address getAddress() {
    	return this.address;
    }
    
    public void setAddress(Address addr) {
    	this.address = addr;
    }
    
    public String store() {
    	LOG.info("Saving address: " + address);
    	if (address.getId() != null && address.getId().longValue() != 0) {
    		LOG.info("Updating old entry: " + address.toString());
            Address oldAdress = addressBean.updateAddress(address.getId(), address);
            
            addFlashMessage("Address" + oldAdress.getId() + " updated");
    	} 
    	else {
    		LOG.info("Creating new entry: " + address.toString());
    		Address newAddress = addressBean.createEntry(address.getForename(), address.getSurename(), address.getStreet(), 
    				address.getZipCode(), address.getCity(), address.getCountry());
    		
    		addFlashMessage("Address" + newAddress.getId() + " created");
    	}
    
    	
    
    	return "index.jsf?faces-redirect=true";
    }
    
//    public Address updateAddress(Address address) {
//    	return addressBean.updateAddress(address.getId(), address);
//    }
    
    public String deleteAddress() {
    	addressBean.deleteAddress(address.getId());
    	return "index?faces-redirect=true";
    }
    

    public String cancel() {
            return "index?faces-redirect=true";
    }

}
