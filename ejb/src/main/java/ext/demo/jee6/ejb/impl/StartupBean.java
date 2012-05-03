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
