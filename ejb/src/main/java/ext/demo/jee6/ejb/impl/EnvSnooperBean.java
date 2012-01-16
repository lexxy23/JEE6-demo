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
