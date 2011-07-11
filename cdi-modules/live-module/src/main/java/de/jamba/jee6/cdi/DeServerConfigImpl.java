/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.jamba.jee6.cdi;

import de.jamba.jee6.api.Country;
import de.jamba.jee6.api.ServerConfiguration;

import javax.inject.Named;

/**
 * @author  dstrauss
 */
@Named("default")
public class DeServerConfigImpl implements ServerConfiguration {

    @Override
    public Country getDefaultCountry() {
        return Country.DE;
    }
}
