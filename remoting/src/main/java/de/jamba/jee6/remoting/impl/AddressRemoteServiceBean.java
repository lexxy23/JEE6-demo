/**
 *
 */
package de.jamba.jee6.remoting.impl;

import de.jamba.jee6.api.Address;
import de.jamba.jee6.api.AddressRemoteService;
import de.jamba.jee6.api.AddressService;
import de.jamba.jee6.api.Country;
import de.jamba.jee6.api.annotations.LogCall;
import de.jamba.jee6.api.xml.AddressXml;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * The implementation for remote service. The endpoint will be mounted under
 * /(ejbJarFilename)/AddressRemoteService.
 *
 * @author  dstrauss
 */
@Stateless
@WebService(
    name = "AddressRemoteService",
    targetNamespace = "http://www.jamba.de/ns/jee6Demo",
    serviceName = "jee6-remote"
)
@LogCall
public class AddressRemoteServiceBean implements AddressRemoteService {

    /**
     * The local service to use.
     */
    @EJB
    private AddressService svc;

    /**
     * Inits the bean.
     */
    public AddressRemoteServiceBean() {
        // nothing special to do
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressXml createEntry(@WebParam(name = "fn") String fn,
            @WebParam(name = "sn") String sn,
            @WebParam(name = "street") String str,
            @WebParam(name = "zipcode") String zc,
            @WebParam(name = "city") String city,
            @WebParam(name = "country") Country c) {
        Address a = svc.createEntry(fn, sn, str, zc, city, c);
        if (a == null) {
            return null;
        }
        return new AddressXml(a);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressXml getById(@WebParam(name = "id") long id) {
        Address a = svc.getById(id);
        if (a == null) {
            return null;
        }
        return new AddressXml(a);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<AddressXml> findByName(@WebParam(name = "namePart") String namePart) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressXml updateAddress(@WebParam(name = "oldAddressId") long oldAddressId,
            @WebParam(name = "newAddress") AddressXml newAddress) {
        Address a = svc.updateAddress(oldAddressId, newAddress);
        if (a == null) {
            return null;
        }
        return new AddressXml(a);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteAddress(@WebParam(name = "id") long id) {
        svc.deleteAddress(id);
    }
}
