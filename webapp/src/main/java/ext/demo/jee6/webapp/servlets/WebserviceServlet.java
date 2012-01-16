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
package ext.demo.jee6.webapp.servlets;


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
