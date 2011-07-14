/**
 *
 */
package ext.demo.jee6.ejb.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author  dstrauss
 */
@Singleton
@Startup
public class EnvSnooperBean {

    /**
     * A logger.
     */
    private static final Logger LOG = Logger.getLogger(EnvSnooperBean.class.getName());

    /**
     */
    public EnvSnooperBean() {
        // nothing special.
    }

    /**
     * Performs the lookup of the current environment and sets some properties into the JNDI.
     */
    @PostConstruct
    public void startup() {
        String envStr = System.getProperty("env");
        if ((envStr == null) || (envStr.length() <= 0)) {
            envStr = "test";
        }
        try {
            Context ctx = new InitialContext();
            ctx.rebind("jee6/env", envStr);
            LOG.info("done, env is now " + envStr);
        } catch (NamingException e) {
            LOG.log(Level.SEVERE, "error when setting up the jndi", e);
        }
    }
}
