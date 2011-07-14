/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ext.demo.jee6.api;

/**
 * A simple server config.
 *
 * @author  dstrauss
 */
public interface ServerConfiguration {

    /**
     * Returns the default country to use.
     *
     * @return  a default country.
     */
    Country getDefaultCountry();
}
