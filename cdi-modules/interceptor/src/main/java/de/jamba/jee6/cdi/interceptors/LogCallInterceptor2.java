/**
 *
 */
package de.jamba.jee6.cdi.interceptors;

import de.jamba.jee6.api.annotations.LogCall;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * Interceptor for logging calls.
 *
 * @author  dstrauss
 */
@Interceptor
@LogCall
public class LogCallInterceptor2 {

    /**
     * A logger.
     */
    private static final Logger LOG = Logger.getLogger(LogCallInterceptor2.class.getName());

    /**
     * Inits the logger.
     */
    public LogCallInterceptor2() {
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
        LOG.log(Level.INFO, "Invoking method {0}", ic.getMethod().toGenericString());
        rc = ic.proceed();
        return rc;
    }
}
