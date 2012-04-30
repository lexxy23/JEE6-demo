package backing;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;

import ext.demo.jee6.api.Address;
import ext.demo.jee6.ejb.impl.AddressServiceBean;
import ext.demo.jee6.jpa.impl.PersistenceServiceBean;

@Named
public class AddressEdit {

	private static final Logger LOG = Logger.getLogger(AddressEdit.class.getName());
	  
	private List<Address> addresses;
	private Address address;
    
    @EJB
    private AddressServiceBean addressBean;
    
    @PostConstruct
    public void init() {
    	LOG.info("Retrieving all addreses from database");
        //addresses = addressBean.getAll();
    }

    public List<Address> getAddresses() {
        return addresses;
    }
    
    public Address getAddress() {
    	return this.address;
    }
    
    public void setAddress(Address address) {
    	this.address = address;
    }
    
//    public Address saveAddress(Address address) {
//    	return addressBean.store(address);
//    }
//    
//    public Address updateAddress(Address address) {
//    	return addressBean.updateEntity(address);
//    }
//    
//    public void deleteAddress(Address address) {
//    	addressBean.delete(address);
//    }
//	
	@Inject
	public AddressEdit () {
		
	}
}
