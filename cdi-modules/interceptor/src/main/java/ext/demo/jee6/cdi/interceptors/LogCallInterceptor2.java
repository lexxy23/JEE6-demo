/**
 *
 */
package ext.demo.jee6.cdi.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import ext.demo.jee6.api.annotations.LogCall;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * INFO Interceptor for logging calls.
 *
 * @author  dstrauss
 */
@Interceptor
@LogCall(level = LogCall.LogLevel.INFO)
public class LogCallInterceptor2 {

  /**
   * A logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(LogCallInterceptor2.class);

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
    LOG.info("Invoking method {}", ic.getMethod().toGenericString());
    rc = ic.proceed();
    LOG.info("done, rc will be {}", rc);
    return rc;
  }
}
