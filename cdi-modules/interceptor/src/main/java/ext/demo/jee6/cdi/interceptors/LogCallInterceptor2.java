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
