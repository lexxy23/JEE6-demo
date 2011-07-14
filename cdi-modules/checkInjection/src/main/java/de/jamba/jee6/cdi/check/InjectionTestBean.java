/**
 *
 */
package de.jamba.jee6.cdi.check;


import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import javax.inject.Inject;
import javax.inject.Named;

import ext.demo.jee6.api.ServerConfiguration;

/**
 * @author  dstrauss
 */
@Singleton
@Startup
public class InjectionTestBean {

    /**
     * A logger.
     */
    private static final Logger LOG = Logger.getLogger(InjectionTestBean.class.getName());

    /**
     * A configuration. Injected via the EJB container.
     */
    @Inject
    @Named("default")
    private ServerConfiguration conf;

    /**
     * Inits the bean.
     */
    public InjectionTestBean() {
        // nothing special
    }

    /**
     * Method on start.
     */
    @PostConstruct
    public void onStart() {
        LOG.info("being online");
        if (conf != null) {
            LOG.info("Configuration is " + conf);
        } else {
            LOG.severe("No configuration has been injected so far!");
        }
    }
}
