package backing;

import static util.Messages.addFlashMessage;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;

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
	  
//	private List<Address> addresses;
	private Address address = new AddressEntity();
    
    @Inject
    private AddressService addressBean;
    
    public void preRenderView() {
        if (address == null) {
        	LOG.info("Instantiating new address entity");
        	address = new AddressEntity();
        	LOG.info("Instantiating new address entity: " + address.toString());
        }
    }

    
//    public List<Address> getAddresses() {
//    	LOG.info("getAddresses: " + addresses.size());
//        return addresses;
//    }
    
    public Address getAddress() {
    	return this.address;
    }
    
    public void setAddress(Address addr) {
    	this.address = addr;
    }
    
    public String store() {
    	try {
			addressBean = (AddressService)new InitialContext().lookup("java:global/AddressService");
			LOG.info("Looked up bean: "+ addressBean);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	LOG.info("Saving address: " + address);
    	if (address.getId() != null) {
    		LOG.info("Updating old entry: " + address.toString());
            addressBean.updateAddress(address.getId(), address);
    	} 
    	else {
    		LOG.info("Creating new entry: " + address.toString());
    		LOG.info(addressBean.sayHello());
    		addressBean.createEntry(address.getForename(), address.getSurename(), address.getStreet(), 
    				address.getZipCode(), address.getCity(), address.getCountry());
    	}
    
    	addFlashMessage("Address" + address.getId() + " saved");
    
    	return "index.jsf?faces-redirect=true";
    }
    
    public Address updateAddress(Address address) {
    	return addressBean.updateAddress(address.getId(), address);
    }
    
    public void deleteAddress(Address address) {
    	addressBean.deleteAddress(address.getId());
    }
}
