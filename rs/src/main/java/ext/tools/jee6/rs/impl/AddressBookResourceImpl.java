/**
 *
 */
package ext.tools.jee6.rs.impl;

import ext.demo.jee6.api.Address;
import ext.demo.jee6.api.AddressService;
import ext.demo.jee6.api.xml.AddressXml;

import ext.tools.jee6.rs.api.AddressbookResource;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

/**
 * @author  dstrauss
 */
public class AddressBookResourceImpl implements AddressbookResource {

    @EJB
    private AddressService svc;

    /**
     */
    public AddressBookResourceImpl() {
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * @see
     * ext.tools.jee6.rs.api.AddressbookResource#createAddress(ext.demo.jee6
     * .api.xml.AddressXml)
     */
    @Override
    public AddressXml createAddress(final AddressXml a) {
        Address ad = svc.createEntry(a.getForename(), a.getSurename(), a.getStreet(), a.getZipCode(), a.getCity(),
                a.getCountry());
        if (ad != null) {
            return new AddressXml(ad);
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * @see ext.tools.jee6.rs.api.AddressbookResource#getAddressById(long)
     */
    @Override
    public AddressXml getAddressById(final long id) {
        Address ad = svc.getById(id);
        if (ad == null) {
            return null;
        }
        AddressXml rc = new AddressXml(ad);
        return rc;
    }

    /*
     * (non-Javadoc)
     * @see ext.tools.jee6.rs.api.AddressbookResource#getAllAddresses()
     */
    @Override
    public List<AddressXml> getAllAddresses() {
        List<Address> al = svc.findAllAddresses();
        if (al == null) {
            return null;
        }
        List<AddressXml> rc = new ArrayList<AddressXml>(al.size());
        for (Address ad : al) {
            rc.add(new AddressXml(ad));
        }
        return rc;
    }

    @Override
    public AddressXml updateAddress(long id, AddressXml a) {
        Address rc = svc.updateAddress(id, a);
        if (rc == null) {
            return a;
        }
        return new AddressXml(rc);
    }
}
