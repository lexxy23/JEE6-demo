/**
 *
 */
package de.jamba.jee6.cdi.check;

import de.jamba.jee6.api.ServerConfiguration;
import de.jamba.jee6.api.annotations.LogCall;

import javax.ejb.Stateless;

import javax.inject.Inject;
import javax.inject.Named;

import javax.jws.WebService;

/**
 * @author  dstrauss
 */
@Stateless
@WebService(
    serviceName = "jee6-inj-test",
    name = "InjectionTestService"
)
@LogCall
public class InjectionTestRemoteBean {

    /**
     * The server config to use.
     */
    @Inject
    @Named("default")
    private ServerConfiguration conf;

    /**
     */
    public InjectionTestRemoteBean() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Returns the config name.
     *
     * @return  the config name
     */
    public String getConfig() {
        if (conf == null) {
            return "no config";
        }
        return conf.getDefaultCountry().name();
    }
}