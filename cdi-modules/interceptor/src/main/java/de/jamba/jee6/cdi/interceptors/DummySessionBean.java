/**
 *
 */
package de.jamba.jee6.cdi.interceptors;

import javax.ejb.Stateless;

import javax.interceptor.Interceptors;

/**
 * @author  dstrauss
 */
@Stateless
@Interceptors({ LogCallInterceptor2.class })
public class DummySessionBean {

    /**
     */
    public DummySessionBean() {
        // TODO Auto-generated constructor stub
    }
}
