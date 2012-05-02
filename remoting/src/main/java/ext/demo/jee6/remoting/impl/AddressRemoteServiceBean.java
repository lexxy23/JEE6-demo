/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <http://unlicense.org/>
 */
/**
 *
 */
package ext.demo.jee6.remoting.impl;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.jws.WebParam;
import javax.jws.WebService;

import ext.demo.jee6.api.Address;
import ext.demo.jee6.api.AddressRemoteService;
import ext.demo.jee6.api.AddressService;
import ext.demo.jee6.api.Country;
import ext.demo.jee6.api.annotations.LogCall;
import ext.demo.jee6.api.xml.AddressXml;

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
            @WebParam(name = "country") String c) {
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
