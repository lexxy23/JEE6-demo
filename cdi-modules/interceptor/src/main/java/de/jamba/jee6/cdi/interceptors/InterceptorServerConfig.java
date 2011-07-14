/**
 *
 */
package de.jamba.jee6.cdi.interceptors;

import ext.demo.jee6.api.Country;
import ext.demo.jee6.api.ServerConfiguration;

/**
 * @author  dstrauss
 */
public class InterceptorServerConfig implements ServerConfiguration {

    /**
     */
    public InterceptorServerConfig() {
        System.out.println("Using Interceptor sc");
    }

    /* (non-Javadoc)
     * @see de.jamba.jee6.api.ServerConfiguration#getDefaultCountry()
     */
    @Override
    public Country getDefaultCountry() {
        return Country.DE;
    }
}
