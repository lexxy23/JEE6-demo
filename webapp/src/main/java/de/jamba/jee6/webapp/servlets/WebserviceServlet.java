package de.jamba.jee6.webapp.servlets;


import java.util.List;

import javax.ejb.EJB;

import javax.jws.WebService;

import javax.servlet.annotation.WebServlet;

import ext.demo.jee6.api.AddressRemoteService;
import ext.demo.jee6.api.Country;
import ext.demo.jee6.api.annotations.LogCall;
import ext.demo.jee6.api.xml.AddressXml;

/**
 * @author  dstrauss
 */
@WebServlet(
    name = "ws1",
    urlPatterns = { "/ws1" }
)
@WebService(name = "n1")
@LogCall
public class WebserviceServlet implements AddressRemoteService {

    /**
     * The remote service.
     */
    @EJB
    private AddressRemoteService svc;

    /**
     */
    public WebserviceServlet() {
        // nothing special to do. The jee6 server will inject the service automatically.
    }

    @Override
    public AddressXml createEntry(String arg0, String arg1, String arg2, String arg3, String arg4, Country arg5) {
        return svc.createEntry(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    @Override
    public void deleteAddress(long arg0) {
        svc.deleteAddress(arg0);
    }

    @Override
    public List<AddressXml> findByName(String arg0) {
        return svc.findByName(arg0);
    }

    @Override
    public AddressXml getById(long arg0) {
        return svc.getById(arg0);
    }

    @Override
    public AddressXml updateAddress(long arg0, AddressXml arg1) {
        return svc.updateAddress(arg0, arg1);
    }
}
