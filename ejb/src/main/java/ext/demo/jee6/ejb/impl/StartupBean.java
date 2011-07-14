/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ext.demo.jee6.ejb.impl;


import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import javax.inject.Inject;
import javax.inject.Named;

import ext.demo.jee6.api.ServerConfiguration;

/**
 * Simple startup bean to check if we have the right configuration.
 *
 * @author  dstrauss
 */
@Singleton
@Startup
public class StartupBean {

    /**
     * A logger.
     */
    private static final Logger LOG = Logger.getLogger(StartupBean.class.getName());

    /**
     * Any server config.
     */
    @Inject
    @Named("default")
    private ServerConfiguration serverConf;

    /**
     * Methods to perform on server startup.
     */
    @PostConstruct
    public void start() {
        if (serverConf == null) {
            LOG.severe("No ServerConf has been injected so far");
        } else {
            LOG.log(Level.INFO, "Powering up with country={0}", serverConf.getDefaultCountry());
        }
    }

    /**
     * Methods to perform on shutdown.
     */
    @PreDestroy
    public void performStopOperations() {
        LOG.info("Shutting down service");
    }
}
