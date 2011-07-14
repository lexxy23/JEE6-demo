/**
 *
 */
package de.jamba.jee6.interceptors;


import java.util.logging.Level;
import java.util.logging.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import ext.demo.jee6.api.annotations.LogCall;

/**
 * Interceptor for logging calls.
 *
 * @author  dstrauss
 */
@LogCall
@Interceptor
public class LogCallInterceptor {

    /**
     * A logger.
     */
    private static final Logger LOG = Logger.getLogger(LogCallInterceptor.class.getName());

    /**
     * Inits the logger.
     */
    public LogCallInterceptor() {
        // nothing to do
    }

    /**
     * Method to log calls.
     *
     * @param   ic  the invocation context
     *
     * @return  the result of the method
     *
     * @throws  Exception  if an error occurred
     */
    @AroundInvoke
    public Object logCall(InvocationContext ic) throws Exception {
        Object rc = null;
        LOG.log(Level.WARNING, "Invoking method {0}", ic.getMethod().toGenericString());
        rc = ic.proceed();
        return rc;
    }
}
