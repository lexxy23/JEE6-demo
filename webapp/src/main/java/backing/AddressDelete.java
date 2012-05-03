package backing;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ext.demo.jee6.api.Address;
import ext.demo.jee6.api.AddressService;
import ext.demo.jee6.jpa.model.AddressEntity;

@ViewScoped
@ManagedBean
public class AddressDelete {

	private AddressEntity address;

	@Inject
	private AddressService addressBean;

	public String delete() {
		addressBean.deleteAddress(address.getId());
		return "index?faces-redirect=true";
	}

	public String cancel() {
		return "index?faces-redirect=true";
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}
}
