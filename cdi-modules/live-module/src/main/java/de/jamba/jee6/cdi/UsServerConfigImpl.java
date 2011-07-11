/**
 *
 */
package de.jamba.jee6.cdi;

import de.jamba.jee6.api.Country;
import de.jamba.jee6.api.ServerConfiguration;

import javax.inject.Named;

/**
 * @author  dstrauss
 */
@Named("us")
public class UsServerConfigImpl implements ServerConfiguration {

    /**
     */
    public UsServerConfigImpl() {
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see de.jamba.jee6.ejb.api.ServerConfiguration#getDefaultCountry()
     */
    @Override
    public Country getDefaultCountry() {
        return Country.US;
    }
}
