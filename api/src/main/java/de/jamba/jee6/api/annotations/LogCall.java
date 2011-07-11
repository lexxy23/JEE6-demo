/**
 *
 */
package de.jamba.jee6.api.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

/**
 * Interceptor annotation to log any calls to a method or a whole type.
 *
 * @author  dstrauss
 */
@Inherited
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
public @interface LogCall {

    /**
     * Several log levels to use.
     *
     * @author  dstrauss
     */
    enum LogLevel {

        /**
         * The info log level.
         */
        INFO,

        /**
         * The warn log level.
         */
        WARN,

        /**
         * The debug log level.
         */
        DEBUG;
    }

    /**
     * Sets the log level to use when entering/exiting the bean/method.
     * @return the log level
     */
    LogLevel level() default LogLevel.INFO;
}
